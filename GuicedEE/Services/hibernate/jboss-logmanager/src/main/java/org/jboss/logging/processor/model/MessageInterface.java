/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2016, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.logging.processor.model;

import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.lang.model.element.TypeElement;

import org.jboss.logging.annotations.MessageBundle;
import org.jboss.logging.annotations.MessageLogger;
import org.jboss.logging.annotations.ValidIdRange;

/**
 * Date: 28.07.2011
 *
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
public interface MessageInterface extends Comparable<MessageInterface>, ClassType, JavaDocComment, DelegatingTypeElement {

    /**
     * Checks the interface to see if the {@link org.jboss.logging.BasicLogger logger interface} is being extended in
     * this interface.
     *
     * @return {@code true} if this interface extends the logger interface, otherwise {@code false}.
     */
    boolean extendsLoggerInterface();

    /**
     * A set of qualified interface names this interface extends or an empty set.
     *
     * @return a set of interface names or an empty set.
     */
    Set<MessageInterface> extendedInterfaces();

    /**
     * A collection of all the methods this interface needs to implement.
     *
     * @return a collection of methods.
     */
    Collection<MessageMethod> methods();

    /**
     * The project code for the message interface or {@code null} if not annotated with
     * {@link org.jboss.logging.annotations.MessageBundle @MessageBundle} or {@link org.jboss.logging.annotations.MessageLogger @MessageLogger}.
     *
     * @return the project code or {@code null} if not annotated with
     * {@link org.jboss.logging.annotations.MessageBundle @MessageBundle} or {@link org.jboss.logging.annotations.MessageLogger @MessageLogger}
     */
    String projectCode();

    /**
     * The qualified name of the message interface.
     *
     * @return the qualified name.
     */
    String name();

    /**
     * The package name of the message interface.
     *
     * @return the package name.
     */
    String packageName();

    /**
     * The name of the interface without the package.
     *
     * @return the simple interface name.
     */
    String simpleName();

    /**
     * The fully qualified class name to use for log methods. This will generally be the same result as {@link
     * #name()}.
     *
     * @return the fully qualified class name to use for logging.
     */
    String loggingFQCN();

    /**
     * Returns a list of {@link org.jboss.logging.annotations.ValidIdRange valid id ranges}.
     *
     * @return a list of valid id ranges or an empty list
     */
    List<ValidIdRange> validIdRanges();

    /**
     * The length to pad the id with. A value of less than 0 indicates no padding.
     *
     * @return the length to pad the id with
     */
    int getIdLength();

    /**
     * Returns the type to use for the {@code @Generated} annotation. This may return {@code null} of the implementation
     * should not be annotated.
     *
     * @return the type for the generated annotation or {@code null} if no annotation is wanted
     */
    default TypeElement generatedAnnotation() {
        return null;
    }

    /**
     * The properties used to resolve expressions.
     *
     * @return the properties used to resolve expressions
     */
    default Properties expressionProperties() {
        return new Properties();
    }
}
