package com.guicedee.guicedservlets.webservices;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WSContext
{
	private static final Set<String> providers = new HashSet<>();
	/**
	 * Provides the url that the module will use to provide Web Services.
	 * Does not default to module name, default to WebServices
	 * <p>
	 *
	 * <p>
	 * e.g. http://localhost/WebServices/helloworld
	 */
	public static String baseWSUrl = "/WebServices";

	static
	{
		providers.add("com.sun.xml.ws.spi.ProviderImpl");
		providers.add("org.apache.cxf.jaxb.JAXBDataBinding");
	}

	public static String renderServices(Set<String> values)
	{
		StringBuilder sb = new StringBuilder();
		for (String pathService : values)
		{
			sb.append(pathService)
			  .append(",");
		}
		if (!values.isEmpty())
		{
			sb = sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public static Set<String> getProviders()
	{
		return providers;
	}
}
