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
package org.apache.logging.log4j.core.util;

import java.io.File;
import java.util.List;

import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationListener;
import org.apache.logging.log4j.core.config.Reconfigurable;

/**
 * Watcher for configuration files. Causes a reconfiguration when a file changes.
 */
public abstract class AbstractWatcher implements Watcher {

    private final Reconfigurable reconfigurable;
    private final List<ConfigurationListener> configurationListeners;
    private final Log4jThreadFactory threadFactory;
    private final Configuration configuration;
    private Source source;

    public AbstractWatcher(final Configuration configuration, final Reconfigurable reconfigurable,
            final List<ConfigurationListener> configurationListeners) {
        this.configuration = configuration;
        this.reconfigurable = reconfigurable;
        this.configurationListeners = configurationListeners;
        this.threadFactory = configurationListeners != null ?
            Log4jThreadFactory.createDaemonThreadFactory("ConfiguratonFileWatcher") : null;
    }

    @Override
    public List<ConfigurationListener> getListeners() {
        return configurationListeners;
    }

    @Override
    public void modified() {
        for (final ConfigurationListener configurationListener : configurationListeners) {
            final Thread thread = threadFactory.newThread(new ReconfigurationRunnable(configurationListener, reconfigurable));
            thread.start();
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public abstract long getLastModified();

    public abstract boolean isModified();

    @Override
    public void watching(Source source) {
        this.source = source;
    }

    @Override
    public Source getSource() {
        return source;
    }

    /**
     * Helper class for triggering a reconfiguration in a background thread.
     */
    public static class ReconfigurationRunnable implements Runnable {

        private final ConfigurationListener configurationListener;
        private final Reconfigurable reconfigurable;

        public ReconfigurationRunnable(final ConfigurationListener configurationListener, final Reconfigurable reconfigurable) {
            this.configurationListener = configurationListener;
            this.reconfigurable = reconfigurable;
        }

        @Override
        public void run() {
            configurationListener.onChange(reconfigurable);
        }
    }
}
