package org.apache.lucene3_4.util;

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


/**
 * Use by certain classes to match version compatibility
 * across releases of Lucene.
 * 
 * <p><b>WARNING</b>: When changing the version parameter
 * that you supply to components in Lucene, do not simply
 * change the version at search-time, but instead also adjust
 * your indexing code to match, and re-index.
 */
// remove me when java 5 is no longer supported
// this is a workaround for a JDK bug that wrongly emits a warning.
@SuppressWarnings("dep-ann")
public enum Version {

  /** Match settings and bugs in Lucene's 2.0 release. 
   * @deprecated (3.1) Use latest 
   */
  @Deprecated
  LUCENE_20,

  /** Match settings and bugs in Lucene's 2.1 release. 
   * @deprecated (3.1) Use latest 
   */
  @Deprecated
  LUCENE_21,

  /** Match settings and bugs in Lucene's 2.2 release. 
   * @deprecated (3.1) Use latest 
   */
  @Deprecated
  LUCENE_22,

  /** Match settings and bugs in Lucene's 2.3 release. 
   * @deprecated (3.1) Use latest 
   */
  @Deprecated
  LUCENE_23,

  /** Match settings and bugs in Lucene's 2.4 release. 
   * @deprecated (3.1) Use latest 
   */
  @Deprecated
  LUCENE_24,

  /** Match settings and bugs in Lucene's 2.9 release. 
   * @deprecated (3.1) Use latest 
   */
  @Deprecated
  LUCENE_29,

  /** Match settings and bugs in Lucene's 3.0 release. */
  LUCENE_30,

  /** Match settings and bugs in Lucene's 3.1 release. */
  LUCENE_31,
  
  /** Match settings and bugs in Lucene's 3.2 release. */
  LUCENE_32,
  
  /** Match settings and bugs in Lucene's 3.3 release. */
  LUCENE_33,
  
  /**
   * Match settings and bugs in Lucene's 3.4 release.
   * <p>
   * Use this to get the latest &amp; greatest settings, bug
   * fixes, etc, for Lucene.
   */
  LUCENE_34,
  
  /* Add new constants for later versions **here** to respect order! */

  /**
   * <p><b>WARNING</b>: if you use this setting, and then
   * upgrade to a newer release of Lucene, sizable changes
   * may happen.  If backwards compatibility is important
   * then you should instead explicitly specify an actual
   * version.
   * <p>
   * If you use this constant then you  may need to 
   * <b>re-index all of your documents</b> when upgrading
   * Lucene, as the way text is indexed may have changed. 
   * Additionally, you may need to <b>re-test your entire
   * application</b> to ensure it behaves as expected, as 
   * some defaults may have changed and may break functionality 
   * in your application. 
   * @deprecated Use an actual version instead. 
   */
  @Deprecated
  LUCENE_CURRENT;

  public boolean onOrAfter(Version other) {
    return compareTo(other) >= 0;
  }
}