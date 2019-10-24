/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright 2004 The Apache Software Foundation
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

package org.apache.jasper.runtime;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.FunctionMapper;
import javax.el.VariableMapper;

/**
 * Concrete implementation of {@link javax.el.ELContext}.
 * ELContext's constructor is protected to control creation of ELContext
 * objects through their appropriate factory methods.  This version of
 * ELContext forces construction through JspApplicationContextImpl.
 *
 * @author Mark Roth
 * @author Kin-man Chung
 */
public class ELContextImpl 
    extends ELContext
{
    /**
     * Constructs a new ELContext associated with the given ELResolver.
     */
    public ELContextImpl(ELResolver resolver) {
        this.resolver = resolver;
    }

    public ELResolver getELResolver() {
        return resolver;
    }

    public void setFunctionMapper(FunctionMapper fnMapper) {
        functionMapper = fnMapper;
    }

    public FunctionMapper getFunctionMapper() {
        return functionMapper;
    }

    public void setVariableMapper(VariableMapper varMapper) {
        variableMapper = varMapper;
    }

    public VariableMapper getVariableMapper() {
        return variableMapper;
    }

    private FunctionMapper functionMapper;
    private VariableMapper variableMapper;
    private ELResolver resolver;
}
