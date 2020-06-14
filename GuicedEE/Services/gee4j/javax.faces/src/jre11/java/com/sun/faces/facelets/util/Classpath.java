package com.sun.faces.facelets.util;

import com.guicedee.guicedinjection.GuiceContext;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

/**
 * @author Jacob Hookom
 * @author Roland Huss
 * @author Ales Justin (ales.justin@jboss.org)
 */
public final class Classpath
{
	/**
	 *
	 */
	public Classpath()
	{
		super();
	}

	public static URL[] search(String prefix, String suffix)
			throws IOException
	{
		return search(Thread.currentThread()
		                    .getContextClassLoader(), prefix,
		              suffix, com.sun.faces.facelets.util.Classpath.SearchAdvice.AllMatches);
	}

	public static URL[] search(ClassLoader cl, String prefix, String suffix,
	                           com.sun.faces.facelets.util.Classpath.SearchAdvice advice)
			throws IOException
	{
		if (suffix.startsWith("."))
		{
			suffix = suffix.substring(1);
		}
		final Set<URL> all = new LinkedHashSet<>();
		GuiceContext.instance()
		            .getScanResult()
		            .getResourcesMatchingPattern(Pattern.compile(".*\\b(" + prefix + ")\\b.*\\b(" + suffix + ")\\b"))
		            .forEach(a ->
		                     {
			                     all.add(a.getURL());
		                     });
		return all.toArray(new URL[0]);
	}

	public static URL[] search(ClassLoader cl, String prefix, String suffix)
			throws IOException
	{
		return search(cl, prefix, suffix, com.sun.faces.facelets.util.Classpath.SearchAdvice.AllMatches);
	}

	public enum SearchAdvice
	{
		FirstMatchOnly,
		AllMatches
	}

}
