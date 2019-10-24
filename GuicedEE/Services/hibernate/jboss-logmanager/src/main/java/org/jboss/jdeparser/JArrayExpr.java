/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.jdeparser;

/**
 * An array expression, which can have more values added to it.
 */
public interface JArrayExpr extends JExpr {

    // originals

    /**
     * Add an element to this array.  Returns this array.
     *
     * @param value the value to add
     * @return this array expression
     */
    JArrayExpr add(JExpr value);

    /**
     * Get the current number of elements added to this array.
     *
     * @return the number of elements
     */
    int elementCount();
}
