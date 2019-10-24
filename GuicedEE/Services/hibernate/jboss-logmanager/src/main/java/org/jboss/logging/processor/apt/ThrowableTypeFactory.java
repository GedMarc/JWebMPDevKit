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

package org.jboss.logging.processor.apt;

import static org.jboss.logging.processor.util.Objects.HashCodeBuilder;
import static org.jboss.logging.processor.util.Objects.areEqual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;

import org.jboss.logging.annotations.Param;
import org.jboss.logging.annotations.Signature;
import org.jboss.logging.processor.model.MessageMethod;
import org.jboss.logging.processor.model.Parameter;
import org.jboss.logging.processor.model.ThrowableType;
import org.jboss.logging.processor.util.ElementHelper;
import org.jboss.logging.processor.util.Objects;

/**
 * Describes information about the return type.
 *
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
final class ThrowableTypeFactory {
    private ThrowableTypeFactory() {
    }

    /**
     * Creates a new descriptor that is not primitive.
     *
     * @param processingEnv the annotation processing environment.
     * @param type                  the class name of the return type.
     * @param messageMethod         the message method.
     *
     * @return the return type descriptor.
     */
    public static ThrowableType forReturnType(final ProcessingEnvironment processingEnv, final TypeMirror type, final MessageMethod messageMethod) {
        final AptReturnThrowableType result = new AptReturnThrowableType(processingEnv, messageMethod, type);
        result.init();
        return result;
    }

    /**
     * Creates a new descriptor that is not primitive.
     *
     * @param processingEnv the annotation processing environment.
     * @param type                  the class name of the return type.
     *
     * @return the return type descriptor.
     */
    public static ThrowableType of(final ProcessingEnvironment processingEnv, final TypeMirror type) {
        final AptThrowableType result = new AptThrowableType(processingEnv, type);
        result.init();
        return result;
    }

    private static class AptThrowableType extends AbstractClassType implements ThrowableType {

        private final TypeMirror type;
        private final boolean isChecked;
        private final Element delegate;
        private boolean defaultConstructor = false;
        private boolean stringConstructor = false;
        private boolean throwableConstructor = false;
        private boolean stringAndThrowableConstructor = false;
        private boolean throwableAndStringConstructor = false;
        protected final TypeMirror stringType;
        protected final TypeMirror throwableType;

        /**
         * Creates a new descriptor that is not primitive.
         *
         * @param processingEnv the annotation processing environment.
         * @param type                  the class name of the return type.
         */
        private AptThrowableType(final ProcessingEnvironment processingEnv, final TypeMirror type) {
            super(processingEnv, type);
            this.type = type;
            this.delegate = types.asElement(type);
            stringType = ElementHelper.toType(elements, String.class);
            throwableType = ElementHelper.toType(elements, Throwable.class);
            final TypeMirror runtimeException = ElementHelper.toType(elements, RuntimeException.class);
            final TypeMirror error = ElementHelper.toType(elements, Error.class);
            isChecked = !(types.isAssignable(runtimeException, type) && types.isAssignable(error, type));
        }

        /**
         * Initializes the object.
         */
        protected void init() {
            if (!type.getKind().isPrimitive() && type.getKind() != TypeKind.VOID) {
                final Element element = types.asElement(type);
                final List<ExecutableElement> constructors = ElementFilter.constructorsIn(element.getEnclosedElements());
                for (ExecutableElement constructor : constructors) {
                    // Only allow public constructors
                    if (!constructor.getModifiers().contains(Modifier.PUBLIC)) {
                        continue;
                    }
                    final List<? extends VariableElement> params = constructor.getParameters();
                    switch (params.size()) {
                        case 0:
                            defaultConstructor = true;
                            break;
                        case 1:
                            if (types.isAssignable(stringType, params.get(0).asType())) {
                                stringConstructor = true;
                            } else if (types.isAssignable(params.get(0).asType(), throwableType)) {
                                throwableConstructor = true;
                            }
                            break;
                        case 2:
                            if (types.isAssignable(stringType, params.get(0).asType())
                                    && types.isAssignable(params.get(1).asType(), throwableType)) {
                                stringAndThrowableConstructor = true;
                            } else if (types.isAssignable(params.get(0).asType(), throwableType)
                                    && types.isAssignable(stringType, params.get(1).asType())) {
                                throwableAndStringConstructor = true;
                            }
                            break;
                    }
                    init(params);
                }
            }
        }

        /**
         * Allows for additional processing of parameters.
         *
         * @param params the parameters to be processed.
         */
        protected void init(final List<? extends VariableElement> params) {

        }

        @Override
        public Element getDelegate() {
            return delegate;
        }

        @Override
        public TypeMirror asType() {
            return type;
        }

        @Override
        public boolean hasDefaultConstructor() {
            return defaultConstructor;
        }

        @Override
        public boolean hasStringAndThrowableConstructor() {
            return stringAndThrowableConstructor;
        }

        @Override
        public boolean hasStringConstructor() {
            return stringConstructor;
        }

        @Override
        public boolean hasThrowableAndStringConstructor() {
            return throwableAndStringConstructor;
        }

        @Override
        public boolean hasThrowableConstructor() {
            return throwableConstructor;
        }

        @Override
        public boolean useConstructionParameters() {
            return false;
        }

        @Override
        public Set<Parameter> constructionParameters() {
            return Collections.emptySet();
        }

        @Override
        public boolean isChecked() {
            return isChecked;
        }

        @Override
        public String name() {
            return type.toString();
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.builder().add(type).toHashCode();
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AptThrowableType)) {
                return false;
            }
            final AptThrowableType other = (AptThrowableType) obj;
            return areEqual(this.type, other.type);
        }

        @Override
        public String toString() {
            return Objects.ToStringBuilder.of(this)
                    .add("type", type)
                    .add("stringConstructor", stringConstructor)
                    .add("throwableConstructor", throwableConstructor)
                    .add("stringAndThrowableConstructor", stringAndThrowableConstructor)
                    .add("throwableAndStringConstructor", throwableAndStringConstructor).toString();
        }

        @Override
        public int compareTo(final ThrowableType o) {
            return name().compareTo(o.name());
        }
    }

    private static class AptReturnThrowableType extends AptThrowableType {

        private final MessageMethod messageMethod;

        private final Set<Parameter> constructionParameters;

        private boolean useConstructionParameters = false;
        private boolean causeSet = false;

        /**
         * Creates a new descriptor that is not primitive.
         *
         * @param processingEnv the annotation processing environment.
         * @param messageMethod         the message method.
         * @param type                  the class name of the return type.
         */
        private AptReturnThrowableType(final ProcessingEnvironment processingEnv, final MessageMethod messageMethod, final TypeMirror type) {
            super(processingEnv, type);
            this.messageMethod = messageMethod;
            constructionParameters = new LinkedHashSet<>();
        }

        @Override
        protected void init() {
            final ExecutableElement method = messageMethod;
            final Signature signature = method.getAnnotation(Signature.class);
            // If using the @Signature annotation we're attempting to use an exact constructor.
            if (signature != null) {
                final List<TypeMirror> args = ElementHelper.getClassArrayAnnotationValue(method, Signature.class, "value");
                // Validate the constructor exists
                if (!ElementHelper.hasConstructor(types, this, args)) {
                    throw new ProcessingException(method, "Constructor of type %s could not be found with arguments %s", this.asType(), args);
                }
                final int causeIndex = signature.causeIndex();
                final int messageIndex = signature.messageIndex();
                // Note that the messageIndex is required and must be 0 or greater
                if (messageIndex < 0) {
                    throw new ProcessingException(method, "A messageIndex of 0 or greater is required. Value %d is invalid.", messageIndex);
                }
                final List<Parameter> methodConstructorParameters = new ArrayList<>(messageMethod.parametersAnnotatedWith(Param.class));

                constructionParameters.clear();
                useConstructionParameters = true;
                causeSet = !messageMethod.hasCause();
                // The required length is the number of parameters plus the message and optional cause.
                final int len = methodConstructorParameters.size() + (causeIndex < 0 ? 1 : 2);
                int offset = 0;
                for (int i = 0; i < len; i++) {
                    if (causeIndex == i) {
                        causeSet = true;
                        constructionParameters.add(messageMethod.cause());
                        offset++;
                    } else if (messageIndex == i) {
                        constructionParameters.add(ParameterFactory.forMessageMethod(messageMethod));
                        offset++;
                    } else {
                        constructionParameters.add(methodConstructorParameters.get(i - offset));
                    }
                }

            } else {
                super.init();
            }
        }

        @Override
        protected void init(final List<? extends VariableElement> params) {
            final Set<Parameter> methodConstructorParameters = messageMethod.parametersAnnotatedWith(Param.class);
            // If there are no construction parameters or a constructor was already found, no need to process
            if (methodConstructorParameters.isEmpty() || useConstructionParameters) {
                return;
            }
            // The number of parameters needed has to include the cause, if specified, and the message it self
            final int neededParamSize = methodConstructorParameters.size() + (messageMethod.hasCause() ? 2 : 1);
            if (neededParamSize == params.size()) {
                // Checks for the first constructor that can be used. The compiler will end-up determining the constructor
                // to use, so a best guess should work.
                final Iterator<Parameter> methodParameterIterator = methodConstructorParameters.iterator();
                final Set<Parameter> matchedParams = new LinkedHashSet<>();
                boolean match = false;
                boolean causeFound = false;
                boolean messageFound = false;
                for (VariableElement param : params) {
                    if (!causeFound && messageMethod.hasCause() && types.isAssignable(throwableType, param.asType())) {
                        causeFound = true;
                        matchedParams.add(messageMethod.cause());
                        continue;
                    }
                    if (!messageFound && types.isAssignable(param.asType(), stringType)) {
                        messageFound = true;
                        matchedParams.add(ParameterFactory.forMessageMethod(messageMethod));
                        continue;
                    }

                    if (methodParameterIterator.hasNext()) {
                        final Parameter parameter = methodParameterIterator.next();
                        match = types.isAssignable(parameter.asType(), param.asType());
                        if (match) {
                            matchedParams.add(parameter);
                        }
                    }
                    // Short circuit
                    if (!match) break;
                }

                if (match) {
                    constructionParameters.clear();
                    useConstructionParameters = true;
                    constructionParameters.addAll(matchedParams);
                    causeSet = causeFound;
                }
            }
        }

        @Override
        public boolean useConstructionParameters() {
            return useConstructionParameters;
        }

        @Override
        public boolean causeSetInConstructor() {
            return causeSet;
        }

        @Override
        public Set<Parameter> constructionParameters() {
            return constructionParameters;
        }
    }
}
