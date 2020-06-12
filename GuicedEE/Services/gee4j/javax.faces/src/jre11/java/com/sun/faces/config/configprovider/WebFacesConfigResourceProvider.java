/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.config.configprovider;

import com.guicedee.guicedinjection.GuiceContext;

import javax.servlet.ServletContext;
import java.net.URI;
import java.util.Collection;
import java.util.regex.Pattern;

import static com.sun.faces.config.WebConfiguration.*;
import static com.sun.faces.config.WebConfiguration.WebContextInitParameter.*;

/**
 *
 */
public class WebFacesConfigResourceProvider
		extends BaseWebConfigResourceProvider
{

	/**
	 * <p>
	 * The resource path for the faces configuration in the <code>WEB-INF</code> directory of an application.
	 * </p>
	 */
	private static final String WEB_INF_RESOURCE = "/WEB-INF/faces-config.xml";

	private static final String[] EXCLUDES = {WEB_INF_RESOURCE};
	private static final String SEPARATORS = ",|;";


	// ------------------------------ Methods from ConfigurationResourceProvider


	/**
	 * @see com.sun.faces.spi.ConfigurationResourceProvider#getResources(javax.servlet.ServletContext)
	 */
	@Override
	public Collection<URI> getResources(ServletContext context)
	{

		Collection<URI> all = super.getResources(context);

		// Step 5, parse "/WEB-INF/faces-config.xml" if it exists
		GuiceContext.instance()
		            .getScanResult()
		            .getResourcesMatchingPattern(Pattern.compile(".*\\b(WEB-INF)\\b.*\\b(" + "faces-config.xml" + ")\\b"))
		            .forEachByteArrayIgnoringIOException((key, value) ->
		                                                 {
			                                                 all.add(key.getURI());
		                                                 });

		// PENDING (rlubke,driscoll) this is a temporary measure to prevent
		// having to find the web-based configuration resources twice
		context.setAttribute("com.sun.faces.webresources", all);

		//System.out.println("WebFacesConfigs - " + all.toString());

		return all;
	}


	// ------------------------------ Methods from BaseWebConfigResourceProvider


	@Override
	protected WebContextInitParameter getParameter()
	{
		return JavaxFacesConfigFiles;
	}

	@Override
	protected String getSeparatorRegex()
	{
		return SEPARATORS;
	}

	@Override
	protected String[] getExcludedResources()
	{
		return EXCLUDES;
	}
}
