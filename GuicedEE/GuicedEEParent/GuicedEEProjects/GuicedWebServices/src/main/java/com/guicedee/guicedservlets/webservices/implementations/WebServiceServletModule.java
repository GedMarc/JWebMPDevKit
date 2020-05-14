package com.guicedee.guicedservlets.webservices.implementations;

import com.guicedee.guicedservlets.services.GuiceSiteInjectorModule;
import com.guicedee.guicedservlets.services.IGuiceSiteBinder;
import com.guicedee.logger.LogFactory;

import java.util.logging.Logger;

import static com.guicedee.guicedservlets.webservices.WSContext.*;

public class WebServiceServletModule
		implements IGuiceSiteBinder<GuiceSiteInjectorModule>
{
	private static final Logger log = LogFactory.getLog(WebServiceServletModule.class);

	@Override
	public void onBind(GuiceSiteInjectorModule module)
	{
		log.config("Binding web services to path defined in WSContext - " + baseWSUrl);


		module.serve$(cleanPath(baseWSUrl) + "*")
		      .with(CxfNonSpring.class);
	}

	public static String cleanPath(String path)
	{
		if (!path.startsWith("/"))
		{
			path = "/" + path;
		}
		if (!path.endsWith("/"))
		{
			path = path + "/";
		}
		return path;
	}

}
