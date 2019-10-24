/*
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
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

package org.apache.taglibs.standard.tag.common.core;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.el.VariableMapper;
import javax.el.ELException;

import javax.servlet.jsp.JspApplicationContext;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.taglibs.standard.resources.Resources;

/**
 * <p>Support for handlers of the &lt;set&gt; tag.</p>
 *
 * @author Shawn Bayern
 */
public class SetSupport extends BodyTagSupport {

    //*********************************************************************
    // Internal state

    protected Object value;                             // tag attribute
    protected boolean valueSpecified;			// status
    protected Object target;                            // tag attribute
    protected String property;                          // tag attribute
    private String var;					// tag attribute
    private int scope;					// tag attribute
    private boolean scopeSpecified;			// status

    //*********************************************************************
    // Construction and initialization

    /**
     * Constructs a new handler.  As with TagSupport, subclasses should
     * not provide other constructors and are expected to call the
     * superclass constructor.
     */
    public SetSupport() {
        super();
        init();
    }

    // resets local state
    private void init() {
        value = var = null;
	scopeSpecified = valueSpecified = false;
	scope = PageContext.PAGE_SCOPE;
    }

    // Releases any resources we may have (or inherit)
    public void release() {
        super.release();
        init();
    }


    //*********************************************************************
    // Tag logic

    public int doEndTag() throws JspException {

        Object result;		// what we'll store in scope:var

        // determine the value by...
        if (value != null) {
	    // ... reading our attribute
	    result = value;
  	} else if (valueSpecified) {
	    // ... accepting an explicit null
	    result = null;
	} else {
	    // ... retrieving and trimming our body
	    if (bodyContent == null || bodyContent.getString() == null)
		result = "";
	    else
	        result = bodyContent.getString().trim();
	}

	// decide what to do with the result
	if (var != null) {

	    /*
             * Store the result, letting an IllegalArgumentException
             * propagate back if the scope is invalid (e.g., if an attempt
             * is made to store something in the session without any
	     * HttpSession existing).
             */
	    if (result != null) {
                if (result instanceof ValueExpression) {
                    if (scope != PageContext.PAGE_SCOPE) {
                        throw new JspException(
                            Resources.getMessage("SET_BAD_SCOPE_DEFERRED"));
                    }
                    VariableMapper vm =
                        pageContext.getELContext().getVariableMapper();
                    if (vm != null) {
                        vm.setVariable(var, (ValueExpression)result);
                    }
                } else {
                    // Make sure to clear any previous mapping for this
                    // variable in the variable mapper.
                    if (scope ==  PageContext.PAGE_SCOPE) {
                        VariableMapper vm =
                            pageContext.getELContext().getVariableMapper();
                        if (vm != null) {
                            vm.setVariable(var, null);
                        }
                    }
                    pageContext.setAttribute(var, result, scope);
                }
	    } else {
		if (scopeSpecified)
		    pageContext.removeAttribute(var, scope);
		else
		    pageContext.removeAttribute(var);

                if (scope == PageContext.PAGE_SCOPE) {
                    VariableMapper vm =
                        pageContext.getELContext().getVariableMapper();
                    if (vm != null) {
                        vm.setVariable(var, null);
                    }
                }
	    }

	} else if (target != null) {

	    // save the result to target.property
	    if (target instanceof Map) {
		// ... treating it as a Map entry
		if (result == null)
		    ((Map) target).remove(property);
		else
		    ((Map) target).put(property, result);
	    } else {
		// ... treating it as a bean property
		try {
                    PropertyDescriptor pd[] =
                        Introspector.getBeanInfo(target.getClass())
			    .getPropertyDescriptors();
		    boolean succeeded = false;
                    for (int i = 0; i < pd.length; i++) {
                        if (pd[i].getName().equals(property)) {
			    Method m = pd[i].getWriteMethod();
                            if (m == null) {
                                throw new JspException(
                                    Resources.getMessage("SET_NO_SETTER_METHOD",
				        property));
                            }
			    if (result != null) {  
                                try {
			        m.invoke(target,
			             new Object[] { 
                                         convertToExpectedType(result, m.getParameterTypes()[0])});
                                } catch (javax.el.ELException ex) {
                                    throw new JspTagException(ex);
                                }
			    } else {
				m.invoke(target, new Object[] { null });
			    }
			    succeeded = true;
			}
		    }
		    if (!succeeded) {
			throw new JspTagException(
			    Resources.getMessage("SET_INVALID_PROPERTY",
				property));
		    }
		} catch (IllegalAccessException ex) {
		    throw new JspException(ex);
		} catch (IntrospectionException ex) {
		    throw new JspException(ex);
		} catch (InvocationTargetException ex) {
		    throw new JspException(ex);
		}
	    }
	} else {
	    // should't ever occur because of validation in TLV and setters
	    throw new JspTagException();
	}

	return EVAL_PAGE;
    }
    
    /**
     * Convert an object to an expected type according to the conversion
     * rules of the Expression Language.
     */
    private Object convertToExpectedType( final Object value,
                                          Class expectedType ) {

        JspFactory jspFactory = JspFactory.getDefaultFactory();
        JspApplicationContext jspAppContext =
            jspFactory.getJspApplicationContext(pageContext.getServletContext());
        ExpressionFactory exprFactory = jspAppContext.getExpressionFactory();
        return exprFactory.coerceToType(value, expectedType);
    }

    //*********************************************************************
    // Accessor methods

    // for tag attribute
    public void setVar(String var) {
	this.var = var;
    }

    // for tag attribute
    public void setScope(String scope) {
        this.scope = Util.getScope(scope);
	this.scopeSpecified = true;
    }
}
