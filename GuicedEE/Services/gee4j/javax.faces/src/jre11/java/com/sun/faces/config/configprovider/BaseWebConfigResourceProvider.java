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
import com.sun.faces.config.WebConfiguration;
import com.sun.faces.config.WebConfiguration.WebContextInitParameter;
import com.sun.faces.spi.ConfigurationResourceProvider;
import com.sun.faces.util.FacesLogger;

import javax.servlet.ServletContext;
import java.net.URI;
import java.util.ArrayList;
import java.util.*;
import java.util.logging.Logger;

import static com.guicedee.guicedinjection.json.StaticStrings.*;
import static com.sun.faces.config.WebConfiguration.WebContextInitParameter.*;
import static com.sun.faces.facelets.util.Classpath.*;
import static com.sun.faces.util.Util.*;
import static java.util.Arrays.*;
import static java.util.logging.Level.*;

/**
 *
 */
public abstract class BaseWebConfigResourceProvider
		implements ConfigurationResourceProvider
{

	private static final Logger LOGGER = FacesLogger.CONFIG.getLogger();


	// ------------------------------ Methods from ConfigurationResourceProvider


	@Override
	public Collection<URI> getResources(ServletContext context)
	{

		WebConfiguration webConfig = WebConfiguration.getInstance(context);
		String paths = webConfig.getOptionValue(getParameter());
		Set<URI> urls = new LinkedHashSet<>(6);

		if (paths != null)
		{
			for (String token : split(context, paths.trim(), getSeparatorRegex()))
			{
				String path = token.trim();
				if (!isExcluded(path) && path.length() != 0)
				{
					URI u = getContextURLForPath(context, path);
					if (u != null)
					{
						urls.add(u);
					}
					else
					{
						System.out.println("Base Web Config Provider - Cannot Load URI - " + path);
						if (LOGGER.isLoggable(WARNING))
						{
							LOGGER.log(WARNING,
							           "jsf.config.web_resource_not_found",
							           new Object[]{path, JavaxFacesConfigFiles.getQualifiedName()});
						}
					}
				}

			}
		}

		return urls;
	}


	// ------------------------------------------------------- Protected Methods


	protected abstract WebContextInitParameter getParameter();

	protected abstract String getSeparatorRegex();

	protected boolean isExcluded(String path)
	{
		return binarySearch(getExcludedResources(), path) >= 0;
	}

	protected URI getContextURLForPath(ServletContext context, String path)
	{
		List<URI> uris = new ArrayList<>();
		if (path.startsWith(STRING_FORWARD_SLASH))
		{
			path = path.substring(1);
		}
		if (path.contains(STRING_FORWARD_SLASH))
		{
			path = path.substring(path.lastIndexOf(STRING_FORWARD_SLASH) + 1);
		}

		GuiceContext.instance()
		            .getScanResult()
		            .getResourcesWithLeafName(path)
		            .forEach(a -> uris.add(cleanURI(a.getURI())));
		if (!uris.isEmpty())
		{
			return uris.get(0);
		}
		return null;
	}

	protected abstract String[] getExcludedResources();

}
