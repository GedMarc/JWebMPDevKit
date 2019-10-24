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
 * Looks up keys from environment variables.
 *
 * @since 1.3
 */
final class EnvironmentVariableStringLookup extends AbstractStringLookup {

    /**
     * Defines the singleton for this class.
     */
    static final EnvironmentVariableStringLookup INSTANCE = new EnvironmentVariableStringLookup();

    /**
     * No need to build instances for now.
     */
    private EnvironmentVariableStringLookup() {
        // empty
    }

    /**
     * Looks up the value of the given environment variable.
     *
     * @param key
     *            the key to be looked up, may be null
     * @return The value of the environment variable.
     * @see System#getenv(String)
     */
    @Override
    public String lookup(final String key) {
        // getenv throws NullPointerException if <code>name</code> is <code>null</code>
        return key != null ? System.getenv(key) : null;
    }
}
