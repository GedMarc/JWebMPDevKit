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
package org.apache.logging.log4j.core.selector;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.LoggerContext;

/**
 * Interface used to locate a LoggerContext.
 */
public interface ContextSelector {

    long DEFAULT_STOP_TIMEOUT = 50;

    /**
     * Shuts down the LoggerContext.
     * @param fqcn The fully qualified class name of the caller.
     * @param loader The ClassLoader to use or null.
     * @param currentContext If true returns the current Context, if false returns the Context appropriate
     * @param allContexts if true all LoggerContexts that can be located will be shutdown.
     * @since 2.13.0
     */
    default void shutdown(final String fqcn, final ClassLoader loader, final boolean currentContext,
                          final boolean allContexts) {
        if (hasContext(fqcn, loader, currentContext)) {
            getContext(fqcn, loader, currentContext).stop(DEFAULT_STOP_TIMEOUT, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * Checks to see if a LoggerContext is installed. The default implementation returns false.
     * @param fqcn The fully qualified class name of the caller.
     * @param loader The ClassLoader to use or null.
     * @param currentContext If true returns the current Context, if false returns the Context appropriate
     * for the caller if a more appropriate Context can be determined.
     * @return true if a LoggerContext has been installed, false otherwise.
     * @since 2.13.0
     */
    default boolean hasContext(String fqcn, ClassLoader loader, boolean currentContext) {
        return false;
    }

    /**
     * Returns the LoggerContext.
     * @param fqcn The fully qualified class name of the caller.
     * @param loader ClassLoader to use or null.
     * @param currentContext If true returns the current Context, if false returns the Context appropriate
     * for the caller if a more appropriate Context can be determined.
     * @return The LoggerContext.
     */
    LoggerContext getContext(String fqcn, ClassLoader loader, boolean currentContext);

    /**
     * Returns the LoggerContext.
     * @param fqcn The fully qualified class name of the caller.
     * @param loader ClassLoader to use or null.
     * @param currentContext If true returns the current Context, if false returns the Context appropriate
     * for the caller if a more appropriate Context can be determined.
     * @param configLocation The location of the configuration for the LoggerContext.
     * @return The LoggerContext.
     */
    LoggerContext getContext(String fqcn, ClassLoader loader, boolean currentContext, URI configLocation);

    /**
     * Returns a List of all the available LoggerContexts.
     * @return The List of LoggerContexts.
     */
    List<LoggerContext> getLoggerContexts();

    /**
     * Remove any references to the LoggerContext.
     * @param context The context to remove.
     */
    void removeContext(LoggerContext context);
}
