package org.apache.lucene3_4.index;

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

final class NormsWriterPerThread extends InvertedDocEndConsumerPerThread {
  final NormsWriter normsWriter;
  final DocumentsWriter.DocState docState;

  public NormsWriterPerThread(DocInverterPerThread docInverterPerThread, NormsWriter normsWriter) {
    this.normsWriter = normsWriter;
    docState = docInverterPerThread.docState;
  }

  @Override
  InvertedDocEndConsumerPerField addField(DocInverterPerField docInverterPerField, final FieldInfo fieldInfo) {
    return new NormsWriterPerField(docInverterPerField, this, fieldInfo);
  }

  @Override
  void abort() {}

  @Override
  void startDocument() {}
  @Override
  void finishDocument() {}

  boolean freeRAM() {
    return false;
  }
}
