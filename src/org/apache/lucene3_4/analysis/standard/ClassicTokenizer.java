/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.lucene3_4.analysis.standard;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene3_4.analysis.Tokenizer;
import org.apache.lucene3_4.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene3_4.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene3_4.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene3_4.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene3_4.util.AttributeSource;
import org.apache.lucene3_4.util.Version;

/** A grammar-based tokenizer constructed with JFlex
 *
 * <p> This should be a good tokenizer for most European-language documents:
 *
 * <ul>
 *   <li>Splits words at punctuation characters, removing punctuation. However, a 
 *     dot that's not followed by whitespace is considered part of a token.
 *   <li>Splits words at hyphens, unless there's a number in the token, in which case
 *     the whole token is interpreted as a product number and is not split.
 *   <li>Recognizes email addresses and internet hostnames as one token.
 * </ul>
 *
 * <p>Many applications have specific tokenizer needs.  If this tokenizer does
 * not suit your application, please consider copying this source code
 * directory to your project and maintaining your own grammar-based tokenizer.
 *
 * <a name="version"/>
 * <p>You must specify the required {@link Version}
 * compatibility when creating ClassicAnalyzer:
 * <ul>
 *   <li> As of 2.4, Tokens incorrectly identified as acronyms
 *        are corrected (see <a href="https://issues.apache.org/jira/browse/LUCENE-1068">LUCENE-1608</a>
 * </ul>
 * 
 * ClassicTokenizer was named StandardTokenizer in Lucene versions prior to 3.1.
 * As of 3.1, {@link StandardTokenizer} implements Unicode text segmentation,
 * as specified by UAX#29.
 */

public final class ClassicTokenizer extends Tokenizer {
  /** A private instance of the JFlex-constructed scanner */
  private StandardTokenizerInterface scanner;

  public static final int ALPHANUM          = 0;
  public static final int APOSTROPHE        = 1;
  public static final int ACRONYM           = 2;
  public static final int COMPANY           = 3;
  public static final int EMAIL             = 4;
  public static final int HOST              = 5;
  public static final int NUM               = 6;
  public static final int CJ                = 7;

  /**
   * @deprecated this solves a bug where HOSTs that end with '.' are identified
   *             as ACRONYMs.
   */
  @Deprecated
  public static final int ACRONYM_DEP       = 8;
  
  /** String token types that correspond to token type int constants */
  public static final String [] TOKEN_TYPES = new String [] {
    "<ALPHANUM>",
    "<APOSTROPHE>",
    "<ACRONYM>",
    "<COMPANY>",
    "<EMAIL>",
    "<HOST>",
    "<NUM>",
    "<CJ>",
    "<ACRONYM_DEP>"
  };

  private boolean replaceInvalidAcronym;
    
  private int maxTokenLength = StandardAnalyzer.DEFAULT_MAX_TOKEN_LENGTH;

  /** Set the max allowed token length.  Any token longer
   *  than this is skipped. */
  public void setMaxTokenLength(int length) {
    this.maxTokenLength = length;
  }

  /** @see #setMaxTokenLength */
  public int getMaxTokenLength() {
    return maxTokenLength;
  }

  /**
   * Creates a new instance of the {@link ClassicTokenizer}.  Attaches
   * the <code>input</code> to the newly created JFlex scanner.
   *
   * @param input The input reader
   *
   * See http://issues.apache.org/jira/browse/LUCENE-1068
   */
  public ClassicTokenizer(Version matchVersion, Reader input) {
    super();
    init(input, matchVersion);
  }

  /**
   * Creates a new ClassicTokenizer with a given {@link AttributeSource}. 
   */
  public ClassicTokenizer(Version matchVersion, AttributeSource source, Reader input) {
    super(source);
    init(input, matchVersion);
  }

  /**
   * Creates a new ClassicTokenizer with a given {@link org.apache.lucene3_4.util.AttributeSource.AttributeFactory} 
   */
  public ClassicTokenizer(Version matchVersion, AttributeFactory factory, Reader input) {
    super(factory);
    init(input, matchVersion);
  }

  private final void init(Reader input, Version matchVersion) {
    this.scanner = new ClassicTokenizerImpl(input);

    if (matchVersion.onOrAfter(Version.LUCENE_24)) {
      replaceInvalidAcronym = true;
    } else {
      replaceInvalidAcronym = false;
    }
    this.input = input;    
  }

  // this tokenizer generates three attributes:
  // term offset, positionIncrement and type
  private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
  private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);
  private final PositionIncrementAttribute posIncrAtt = addAttribute(PositionIncrementAttribute.class);
  private final TypeAttribute typeAtt = addAttribute(TypeAttribute.class);

  /*
   * (non-Javadoc)
   *
   * @see org.apache.lucene3_4.analysis.TokenStream#next()
   */
  @Override
  public final boolean incrementToken() throws IOException {
    clearAttributes();
    int posIncr = 1;

    while(true) {
      int tokenType = scanner.getNextToken();

      if (tokenType == StandardTokenizerInterface.YYEOF) {
        return false;
      }

      if (scanner.yylength() <= maxTokenLength) {
        posIncrAtt.setPositionIncrement(posIncr);
        scanner.getText(termAtt);
        final int start = scanner.yychar();
        offsetAtt.setOffset(correctOffset(start), correctOffset(start+termAtt.length()));
        // This 'if' should be removed in the next release. For now, it converts
        // invalid acronyms to HOST. When removed, only the 'else' part should
        // remain.
        if (tokenType == ClassicTokenizer.ACRONYM_DEP) {
          if (replaceInvalidAcronym) {
            typeAtt.setType(ClassicTokenizer.TOKEN_TYPES[ClassicTokenizer.HOST]);
            termAtt.setLength(termAtt.length() - 1); // remove extra '.'
          } else {
            typeAtt.setType(ClassicTokenizer.TOKEN_TYPES[ClassicTokenizer.ACRONYM]);
          }
        } else {
          typeAtt.setType(ClassicTokenizer.TOKEN_TYPES[tokenType]);
        }
        return true;
      } else
        // When we skip a too-long term, we still increment the
        // position increment
        posIncr++;
    }
  }
  
  @Override
  public final void end() {
    // set final offset
    int finalOffset = correctOffset(scanner.yychar() + scanner.yylength());
    offsetAtt.setOffset(finalOffset, finalOffset);
  }

  @Override
  public void reset(Reader reader) throws IOException {
    super.reset(reader);
    scanner.yyreset(reader);
  }

  /**
   * Prior to https://issues.apache.org/jira/browse/LUCENE-1068, ClassicTokenizer mischaracterized as acronyms tokens like www.abc.com
   * when they should have been labeled as hosts instead.
   * @return true if ClassicTokenizer now returns these tokens as Hosts, otherwise false
   *
   * @deprecated Remove in 3.X and make true the only valid value
   */
  @Deprecated
  public boolean isReplaceInvalidAcronym() {
    return replaceInvalidAcronym;
  }

  /**
   *
   * @param replaceInvalidAcronym Set to true to replace mischaracterized acronyms as HOST.
   * @deprecated Remove in 3.X and make true the only valid value
   *
   * See https://issues.apache.org/jira/browse/LUCENE-1068
   */
  @Deprecated
  public void setReplaceInvalidAcronym(boolean replaceInvalidAcronym) {
    this.replaceInvalidAcronym = replaceInvalidAcronym;
  }
}
