package org.apache.lucene3_4.search.spans;

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

import java.io.IOException;

import org.apache.lucene3_4.search.Explanation;
import org.apache.lucene3_4.search.Scorer;
import org.apache.lucene3_4.search.Similarity;
import org.apache.lucene3_4.search.Weight;

/**
 * Public for extension only.
 */
public class SpanScorer extends Scorer {
  protected Spans spans;
  protected byte[] norms;
  protected float value;

  protected boolean more = true;

  protected int doc;
  protected float freq;

  protected SpanScorer(Spans spans, Weight weight, Similarity similarity, byte[] norms)
  throws IOException {
    super(similarity, weight);
    this.spans = spans;
    this.norms = norms;
    this.value = weight.getValue();
    if (this.spans.next()) {
      doc = -1;
    } else {
      doc = NO_MORE_DOCS;
      more = false;
    }
  }

  @Override
  public int nextDoc() throws IOException {
    if (!setFreqCurrentDoc()) {
      doc = NO_MORE_DOCS;
    }
    return doc;
  }

  @Override
  public int advance(int target) throws IOException {
    if (!more) {
      return doc = NO_MORE_DOCS;
    }
    if (spans.doc() < target) { // setFreqCurrentDoc() leaves spans.doc() ahead
      more = spans.skipTo(target);
    }
    if (!setFreqCurrentDoc()) {
      doc = NO_MORE_DOCS;
    }
    return doc;
  }
  
  protected boolean setFreqCurrentDoc() throws IOException {
    if (!more) {
      return false;
    }
    doc = spans.doc();
    freq = 0.0f;
    do {
      int matchLength = spans.end() - spans.start();
      freq += getSimilarity().sloppyFreq(matchLength);
      more = spans.next();
    } while (more && (doc == spans.doc()));
    return true;
  }

  @Override
  public int docID() { return doc; }

  @Override
  public float score() throws IOException {
    float raw = getSimilarity().tf(freq) * value; // raw score
    return norms == null? raw : raw * getSimilarity().decodeNormValue(norms[doc]); // normalize
  }
  
  @Override
  public float freq() throws IOException {
    return freq;
  }

  /** This method is no longer an official member of {@link Scorer},
   * but it is needed by SpanWeight to build an explanation. */
  protected Explanation explain(final int doc) throws IOException {
    Explanation tfExplanation = new Explanation();

    int expDoc = advance(doc);

    float phraseFreq = (expDoc == doc) ? freq : 0.0f;
    tfExplanation.setValue(getSimilarity().tf(phraseFreq));
    tfExplanation.setDescription("tf(phraseFreq=" + phraseFreq + ")");

    return tfExplanation;
  }

}
