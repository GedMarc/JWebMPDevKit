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
package org.jboss.classfilewriter.constpool;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.jboss.classfilewriter.WritableEntry;
import org.jboss.classfilewriter.util.ByteArrayDataOutputStream;


public class ConstPool implements WritableEntry {

    private final LinkedHashMap<Integer, ConstPoolEntry> entries = new LinkedHashMap<Integer, ConstPoolEntry>();

    private final Map<String, Integer> utf8Locations = new HashMap<String, Integer>();
    private final Map<String, Integer> classLocations = new HashMap<String, Integer>();
    private final Map<String, Integer> stringLocations = new HashMap<String, Integer>();
    private final Map<NameAndType, Integer> nameAndTypeLocations = new HashMap<NameAndType, Integer>();
    private final Map<MemberInfo, Integer> fieldLocations = new HashMap<MemberInfo, Integer>();
    private final Map<MemberInfo, Integer> methodLocations = new HashMap<MemberInfo, Integer>();
    private final Map<MemberInfo, Integer> interfaceMethodLocations = new HashMap<MemberInfo, Integer>();
    private final Map<Integer, Integer> integerLocations = new HashMap<Integer, Integer>();
    private final Map<Float, Integer> floatLocations = new HashMap<Float, Integer>();
    private final Map<Long, Integer> longLocations = new HashMap<Long, Integer>();
    private final Map<Double, Integer> doubleLocations = new HashMap<Double, Integer>();

    private int count = 1;

    /**
     * The constant_pool_count field of the class file format
     */
    private Integer constPoolSize = 1;

    public Integer addUtf8Entry(String entry) {
        if (utf8Locations.containsKey(entry)) {
            return utf8Locations.get(entry);
        }
        final int index = count++;
        constPoolSize++;
        entries.put(index, new Utf8Entry(entry));
        utf8Locations.put(entry, index);
        return index;
    }

    /**
     * Adds a CONSTANT_Class_info to the const pool. This must be in internal form
     */
    public Integer addClassEntry(String className) {
        className = className.replace('.', '/');
        if (classLocations.containsKey(className)) {
            return classLocations.get(className);
        }
        final Integer utf8Location = addUtf8Entry(className);
        final Integer index = count++;
        constPoolSize++;
        entries.put(index, new ClassEntry(utf8Location));
        classLocations.put(className, index);
        return index;
    }

    /**
     * Adds a CONSTANT_String_info to the const pool.
     */
    public Integer addStringEntry(String string) {
        if (stringLocations.containsKey(string)) {
            return stringLocations.get(string);
        }
        final Integer utf8Location = addUtf8Entry(string);
        final Integer index = count++;
        constPoolSize++;
        entries.put(index, new StringEntry(utf8Location));
        stringLocations.put(string, index);
        return index;
    }

    public Integer addIntegerEntry(int entry) {
        if (integerLocations.containsKey(entry)) {
            return integerLocations.get(entry);
        }
        final Integer index = count++;
        constPoolSize++;
        entries.put(index, new IntegerEntry(entry));
        integerLocations.put(entry, index);
        return index;
    }

    public Integer addFloatEntry(float entry) {
        if (floatLocations.containsKey(entry)) {
            return floatLocations.get(entry);
        }
        final Integer index = count++;
        constPoolSize++;
        entries.put(index, new FloatEntry(entry));
        floatLocations.put(entry, index);
        return index;
    }

    public Integer addLongEntry(long entry) {
        if (longLocations.containsKey(entry)) {
            return longLocations.get(entry);
        }
        final Integer index = count++;
        count++;
        constPoolSize += 2;
        entries.put(index, new LongEntry(entry));
        longLocations.put(entry, index);
        return index;
    }

    public Integer addDoubleEntry(double entry) {
        if (doubleLocations.containsKey(entry)) {
            return doubleLocations.get(entry);
        }
        final Integer index = count++;
        count++;
        constPoolSize += 2;
        entries.put(index, new DoubleEntry(entry));
        doubleLocations.put(entry, index);
        return index;
    }

    public Integer addNameAndTypeEntry(String name, String type) {
        final NameAndType typeInfo = new NameAndType(name, type);
        if(nameAndTypeLocations.containsKey(typeInfo)) {
            return nameAndTypeLocations.get(typeInfo);
        }
        final Integer nameIndex = addUtf8Entry(name);
        final Integer typeIndex = addUtf8Entry(type);
        final Integer index = count++;
        constPoolSize++;
        entries.put(index,new NameAndTypeEntry(nameIndex, typeIndex));
        nameAndTypeLocations.put(typeInfo, index);
        return index;
    }

    public Integer addFieldEntry(String className, String fieldName, String fieldType) {
        final NameAndType nameAndType = new NameAndType(fieldName, fieldType);
        final MemberInfo field = new MemberInfo(className, nameAndType);
        if (fieldLocations.containsKey(field)) {
            return fieldLocations.get(field);
        }
        final Integer nameAndTypeIndex = addNameAndTypeEntry(fieldName, fieldType);
        final Integer classIndex = addClassEntry(className);
        final Integer index = count++;
        constPoolSize++;
        entries.put(index, new FieldRefEntry(classIndex, nameAndTypeIndex));
        fieldLocations.put(field, index);
        return index;
    }

    public Integer addMethodEntry(String className, String methodName, String descriptor) {
        final NameAndType nameAndType = new NameAndType(methodName, descriptor);
        final MemberInfo method = new MemberInfo(className, nameAndType);
        if (methodLocations.containsKey(method)) {
            return methodLocations.get(method);
        }
        final Integer nameAndTypeIndex = addNameAndTypeEntry(methodName, descriptor);
        final Integer classIndex = addClassEntry(className);
        final Integer index = count++;
        constPoolSize++;
        entries.put(index, new MethodRefEntry(classIndex, nameAndTypeIndex));
        methodLocations.put(method, index);
        return index;
    }

    public Integer addInterfaceMethodEntry(String className, String methodName, String descriptor) {
        final NameAndType nameAndType = new NameAndType(methodName, descriptor);
        final MemberInfo method = new MemberInfo(className, nameAndType);
        if (interfaceMethodLocations.containsKey(method)) {
            return interfaceMethodLocations.get(method);
        }
        final Integer nameAndTypeIndex = addNameAndTypeEntry(methodName, descriptor);
        final Integer classIndex = addClassEntry(className);
        final Integer index = count++;
        constPoolSize++;
        entries.put(index, new InterfaceMethodRefEntry(classIndex, nameAndTypeIndex));
        interfaceMethodLocations.put(method, index);
        return index;
    }

    public void write(ByteArrayDataOutputStream stream) throws IOException {
        stream.writeShort(constPoolSize);
        for (Entry<Integer, ConstPoolEntry> entry : entries.entrySet()) {
            entry.getValue().write(stream);
        }
    }

    private static final class NameAndType {
        private final String name, type;

        public NameAndType(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            result = prime * result + ((type == null) ? 0 : type.hashCode());
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
            NameAndType other = (NameAndType) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            if (type == null) {
                if (other.type != null)
                    return false;
            } else if (!type.equals(other.type))
                return false;
            return true;
        }
    }

    private static class MemberInfo {
        private final String className;
        private final NameAndType nameAndType;

        public MemberInfo(String className,NameAndType nameAndType) {
            this.className = className;
            this.nameAndType = nameAndType;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((className == null) ? 0 : className.hashCode());
            result = prime * result + ((nameAndType == null) ? 0 : nameAndType.hashCode());
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
            MemberInfo other = (MemberInfo) obj;
            if (className == null) {
                if (other.className != null)
                    return false;
            } else if (!className.equals(other.className))
                return false;
            if (nameAndType == null) {
                if (other.nameAndType != null)
                    return false;
            } else if (!nameAndType.equals(other.nameAndType))
                return false;
            return true;
        }

    }
}
