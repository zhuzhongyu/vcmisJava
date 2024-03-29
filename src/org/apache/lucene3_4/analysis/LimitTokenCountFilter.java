package org.apache.lucene3_4.analysis;

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

/**
 * This TokenFilter limits the number of tokens while indexing. It is
 * a replacement for the maximum field length setting inside {@link org.apache.lucene3_4.index.IndexWriter}.
 */
public final class LimitTokenCountFilter extends TokenFilter {

  private final int maxTokenCount;
  private int tokenCount = 0;

  /**
   * Build a filter that only accepts tokens up to a maximum number.
   */
  public LimitTokenCountFilter(TokenStream in, int maxTokenCount) {
    super(in);
    this.maxTokenCount = maxTokenCount;
  }
  
  @Override
  public boolean incrementToken() throws IOException {
    if (tokenCount < maxTokenCount && input.incrementToken()) {
      tokenCount++;
      return true;
    }
    return false;
  }

  @Override
  public void reset() throws IOException {
    super.reset();
    tokenCount = 0;
  }
}
