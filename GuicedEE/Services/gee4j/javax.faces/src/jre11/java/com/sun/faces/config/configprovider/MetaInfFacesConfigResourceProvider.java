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
import com.sun.faces.util.Util;
import com.sun.faces.config.WebConfiguration;
import com.sun.faces.facelets.util.Classpath;
import com.sun.faces.spi.ConfigurationResourceProvider;

import java.net.URISyntaxException;

import javax.faces.FacesException;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static com.sun.faces.util.Util.*;

/**
 *
 */
public class MetaInfFacesConfigResourceProvider
		implements
		ConfigurationResourceProvider
{

	/**
	 * <p>This <code>Pattern</code> will pick the the JAR file name if present
	 * within a URL.</p>
	 */
	private static final Pattern JAR_PATTERN = Pattern.compile(".*/(\\S*\\.jar).*");

	/**
	 * <p>The resource path for faces-config files included in the
	 * <code>META-INF</code> directory of JAR files.</p>
	 */
	private static final String META_INF_RESOURCES =
			"META-INF/faces-config.xml";

	private static final String WEB_INF_CLASSES =
			"/WEB-INF/classes/META-INF";

	private static final String FACES_CONFIG_EXTENSION =
			".faces-config.xml";

	// ------------------------------ Methods From ConfigurationResourceProvider


	/**
	 * @see com.sun.faces.spi.ConfigurationResourceProvider#getResources(javax.servlet.ServletContext)
	 */
	@Override
	public Collection<URI> getResources(ServletContext context)
	{
		WebConfiguration webConfig = WebConfiguration.getInstance(context);
		String duplicateJarPattern = webConfig.getOptionValue(WebConfiguration.WebContextInitParameter.DuplicateJARPattern);
		Pattern duplicatePattern = null;
		if (duplicateJarPattern != null)
		{
			duplicatePattern = Pattern.compile(duplicateJarPattern);
		}
		SortedMap<String, Set<URI>> sortedJarMap = new TreeMap<>();
		//noinspection CollectionWithoutInitialCapacity
		List<URI> unsortedResourceList = new ArrayList<>();

		try
		{
			for (URI uri : loadURLs(context))
			{
				String jarUrl = uri.toString();
				String jarName = null;
				Matcher m = JAR_PATTERN.matcher(jarUrl);
				if (m.matches())
				{
					jarName = m.group(1);
				}
				if (jarName != null)
				{
					if (duplicatePattern != null)
					{
						m = duplicatePattern.matcher(jarName);
						if (m.matches())
						{
							jarName = m.group(1);
						}
					}

					Set<URI> uris = sortedJarMap.get(jarName);
					if (uris == null)
					{
						uris = new HashSet<>();
						sortedJarMap.put(jarName, uris);
					}
					uris.add(uri);
				}
				else
				{
					unsortedResourceList.add(0, uri);
				}
			}
		}
		catch (Exception e)
		{
			throw new FacesException(e);
		}
		// Load the sorted resources first:
		List<URI> result =
				new ArrayList<>(sortedJarMap.size() + unsortedResourceList
						                                      .size());
		for (Map.Entry<String, Set<URI>> entry : sortedJarMap.entrySet())
		{
			result.addAll(entry.getValue());
		}
		// Then load the unsorted resources
		result.addAll(unsortedResourceList);
		java.util.logging.Logger.getLogger("FacesConfigMetaInfLibraries").log(java.util.logging.Level.CONFIG,"Found the following faces-config in META-INF - " + result);
		return result;
	}


	// --------------------------------------------------------- Private Methods

	private Collection<URI> loadURLs(ServletContext context)
	{
		Collection<URI> all = new LinkedHashSet<>();
		try
		{
			URL[] urls = Classpath.search("META-INF", "faces-config.xml");
			for (URL url : urls)
			{
				all.add(URI.create(url.toString()));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return all;
	}
}
