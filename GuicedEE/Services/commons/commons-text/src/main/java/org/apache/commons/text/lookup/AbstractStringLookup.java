/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */

package org.apache.commons.text.lookup;

/**
 * A default lookup for others to extend in this package.
 *
 * @since 1.3
 */
abstract class AbstractStringLookup implements StringLookup {


    /**
     * The empty string.
     */
    private static final String EMPTY = "";

    /**
     * The default split char.
     */
    protected static final char SPLIT_CH = ':';

    /**
     * The default split string.
     */
    protected static final String SPLIT_STR = String.valueOf(SPLIT_CH);

    /**
     * Returns the substring after the first occurrence of <code>ch</code> in <code>value</code>.
     *
     * @param value
     *            The source string.
     * @param ch
     *            The character to search.
     * @return a new string.
     */
    protected String substringAfter(final String value, final char ch) {
        final int indexOf = value.indexOf(ch);
        return indexOf > -1 ? value.substring(indexOf + 1) : EMPTY;
    }

    /**
     * Returns the substring after the first occurrence of <code>ch</code> in <code>value</code>.
     *
     * @param value
     *            The source string.
     * @param ch
     *            The character to search.
     * @return a new string.
     */
    protected String substringAfterLast(final String value, final char ch) {
        final int indexOf = value.lastIndexOf(ch);
        return indexOf > -1 ? value.substring(indexOf + 1) : EMPTY;
    }

    /**
     * Returns the substring after the first occurrence of <code>str</code> in <code>value</code>.
     *
     * @param value
     *            The source string.
     * @param str
     *            The string to search.
     * @return a new string.
     */
    protected String substringAfter(final String value, final String str) {
        final int indexOf = value.indexOf(str);
        return indexOf > -1 ? value.substring(indexOf + str.length()) : EMPTY;
    }
}
