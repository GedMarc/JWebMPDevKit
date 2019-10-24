/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2012 Red Hat, Inc.
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
package org.jboss.classfilewriter;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.jboss.classfilewriter.annotations.AnnotationsAttribute;
import org.jboss.classfilewriter.annotations.ParameterAnnotationsAttribute;
import org.jboss.classfilewriter.attributes.Attribute;
import org.jboss.classfilewriter.attributes.ExceptionsAttribute;
import org.jboss.classfilewriter.attributes.SignatureAttribute;
import org.jboss.classfilewriter.code.CodeAttribute;
import org.jboss.classfilewriter.constpool.ConstPool;
import org.jboss.classfilewriter.util.ByteArrayDataOutputStream;
import org.jboss.classfilewriter.util.DescriptorUtils;


public class ClassMethod implements WritableEntry {

    private final String returnType;
    private final String[] parameters;
    private final String name;
    private final String descriptor;
    private final int accessFlags;

    private final ClassFile classFile;

    /**
     * The index of the name into the const pool
     */
    private final int nameIndex;
    /**
     * the index of the descriptor into the const pool
     */
    private final int descriptorIndex;

    private final List<Attribute> attributes = new ArrayList<Attribute>();

    private final CodeAttribute codeAttribute;

    private final ExceptionsAttribute exceptionsAttribute;

    private final boolean constructor;

    private final AnnotationsAttribute runtimeVisibleAnnotationsAttribute;

    private final ParameterAnnotationsAttribute runtimeVisibleParameterAnnotationsAttribute;

    private SignatureAttribute signatureAttribute;

    private String signature;

    ClassMethod(String name, String returnType, String[] parameters, int accessFlags, ClassFile classFile) {
        ConstPool constPool = classFile.getConstPool();
        this.classFile = classFile;
        this.returnType = DescriptorUtils.validateDescriptor(returnType);
        this.parameters = parameters;
        this.name = name;
        this.descriptor = DescriptorUtils.methodDescriptor(parameters, returnType);
        this.accessFlags = accessFlags;
        this.nameIndex = constPool.addUtf8Entry(name);
        this.descriptorIndex = constPool.addUtf8Entry(descriptor);
        this.constructor = name.equals("<init>");
        this.exceptionsAttribute = new ExceptionsAttribute(constPool);
        this.attributes.add(exceptionsAttribute);

        if (Modifier.isAbstract(accessFlags)) {
            codeAttribute = null;
        } else {
            codeAttribute = new CodeAttribute(this, constPool);
            attributes.add(codeAttribute);
        }
        for (String param : this.parameters) {
            DescriptorUtils.validateDescriptor(param);
        }
        this.runtimeVisibleAnnotationsAttribute = new AnnotationsAttribute(AnnotationsAttribute.Type.RUNTIME_VISIBLE, constPool);
        this.attributes.add(runtimeVisibleAnnotationsAttribute);
        this.runtimeVisibleParameterAnnotationsAttribute = new ParameterAnnotationsAttribute(
                ParameterAnnotationsAttribute.Type.RUNTIME_VISIBLE, constPool, parameters.length);
        this.attributes.add(runtimeVisibleParameterAnnotationsAttribute);
    }

    public void addCheckedExceptions(Class<? extends Exception>... exceptions) {
        for (Class<? extends Exception> exception : exceptions) {
            exceptionsAttribute.addExceptionClass(exception.getName());
        }
    }

    public void addCheckedExceptions(String... exceptions) {
        for (String exception : exceptions) {
            exceptionsAttribute.addExceptionClass(exception);
        }
    }

    public void write(ByteArrayDataOutputStream stream) throws IOException {
        if(signatureAttribute != null) {
            attributes.add(signatureAttribute);
        }
        stream.writeShort(accessFlags);
        stream.writeShort(nameIndex);
        stream.writeShort(descriptorIndex);
        stream.writeShort(attributes.size());
        for (Attribute attribute : attributes) {
            attribute.write(stream);
        }
    }


    public CodeAttribute getCodeAttribute() {
        return codeAttribute;
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public String getReturnType() {
        return returnType;
    }

    public String[] getParameters() {
        return parameters;
    }

    public String getName() {
        return name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public boolean isConstructor() {
        return constructor;
    }

    public boolean isStatic() {
        return Modifier.isStatic(accessFlags);
    }

    public ClassFile getClassFile() {
        return classFile;
    }

    public AnnotationsAttribute getRuntimeVisibleAnnotationsAttribute() {
        return runtimeVisibleAnnotationsAttribute;
    }

    public ParameterAnnotationsAttribute getRuntimeVisibleParameterAnnotationsAttribute() {
        return runtimeVisibleParameterAnnotationsAttribute;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        if(signature == null) {
            signatureAttribute = null;
        } else {
            signatureAttribute = new SignatureAttribute(classFile.getConstPool(), signature);
        }
        this.signature = signature;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descriptor == null) ? 0 : descriptor.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ClassMethod other = (ClassMethod) obj;
        if (descriptor == null) {
            if (other.descriptor != null)
                return false;
        } else if (!descriptor.equals(other.descriptor))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ClassMethod: " + name + descriptor;
    }
}
