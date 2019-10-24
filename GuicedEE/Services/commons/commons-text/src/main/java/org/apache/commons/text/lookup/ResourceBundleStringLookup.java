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

import java.util.ResourceBundle;

/**
 * Looks up keys from resource bundles.
 * <p>
 * Looks up the value for a given key in the format "BundleName:BundleKey".
 * </p>
 * <p>
 * For example: "com.domain.messages:MyKey".
 * </p>
 *
 * @see ResourceBundle
 * @since 1.3
 */
final class ResourceBundleStringLookup extends AbstractStringLookup {

    /**
     * The name of the resource bundle from which to look something up.
     */
    private final String bundleName;

    /**
     * Defines the singleton for this class.
     */
    static final ResourceBundleStringLookup INSTANCE = new ResourceBundleStringLookup();

    /**
     * No need to build instances for now.
     */
    private ResourceBundleStringLookup() {
        this(null);
    }

    /**
     * Constructs an instance that only works for the given bundle.
     *
     * @param bundleName
     *            the name of the resource bundle from which we will look keys up.
     * @since 1.5
     */
    ResourceBundleStringLookup(final String bundleName) {
        this.bundleName = bundleName;
    }

    /**
     * Looks up the value for the key in the format "BundleName:BundleKey".
     *
     * For example: "com.domain.messages:MyKey".
     *
     * @param key
     *            the key to be looked up, may be null
     * @return The value associated with the key.
     * @see ResourceBundle
     * @see ResourceBundle#getBundle(String)
     * @see ResourceBundle#getString(String)
     */
    @Override
    public String lookup(final String key) {
        if (key == null) {
            return null;
        }
        final String[] keys = key.split(SPLIT_STR);
        final int keyLen = keys.length;
        final boolean anyBundle = bundleName == null;
        if (anyBundle && keyLen != 2) {
            throw IllegalArgumentExceptions
                    .format("Bad resource bundle key format [%s]; expected format is BundleName:KeyName.", key);
        } else if (bundleName != null && keyLen != 1) {
            throw IllegalArgumentExceptions.format("Bad resource bundle key format [%s]; expected format is KeyName.",
                    key);
        }
        final String keyBundleName = anyBundle ? keys[0] : bundleName;
        final String bundleKey = anyBundle ? keys[1] : keys[0];
        try {
            // The ResourceBundle class caches bundles, no need to cache here.
            return ResourceBundle.getBundle(keyBundleName).getString(bundleKey);
        } catch (final Exception e) {
            throw IllegalArgumentExceptions.format(e, "Error looking up resource bundle [%s] and key [%s].",
                    keyBundleName, bundleKey);
        }
    }

}
