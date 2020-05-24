package com.guicedee.guicedservlets.webservices.implementations;

import com.google.inject.Singleton;
import com.guicedee.guicedinjection.GuiceContext;
import com.guicedee.guicedservlets.webservices.WSContext;
import com.guicedee.logger.LogFactory;
import io.github.classgraph.ClassInfo;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.jws.WebService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Endpoint;
import java.util.logging.Level;

@Singleton
public class CxfNonSpring
		extends CXFNonSpringServlet
{
	@Override
	protected void loadBus(ServletConfig sc)
	{
		super.loadBus(sc);
		BusFactory.setDefaultBus(getBus());

		for (ClassInfo classInfo : GuiceContext.instance()
		                                       .getScanResult()
		                                       .getClassesWithAnnotation(WebService.class.getCanonicalName()))
		{
			Class<?> calledType = classInfo.loadClass();
			WebService anno = calledType.getAnnotation(WebService.class);
			try
			{
				if (classInfo.isInterface() || classInfo.isAbstract())
				{
					LogFactory.getLog(CxfNonSpring.class)
					          .log(Level.WARNING, "Not creating web service for [" + calledType.getCanonicalName() + "]. Interface/Abstract.");
					continue;
				}
				Object o = GuiceContext.get(calledType);
				Endpoint endpoint = Endpoint.create(o);
				String path = (anno.name()
				                   .isEmpty() ? "/" + calledType.getSimpleName() : anno.name());
				path = WebServiceServletModule.cleanPath(WSContext.baseWSUrl) + path;

				Endpoint.publish(path, o);
				LogFactory.getLog(CxfNonSpring.class)
				          .info("WS Endpoint Active on Default WSContext Settings : " + path);
			}
			catch (Exception e)
			{
				LogFactory.getLog(CxfNonSpring.class)
				          .log(Level.SEVERE, "Not creating web service for [" + calledType.getCanonicalName() + "]. - " + e.getMessage(), e);
				LogFactory.getLog(CxfNonSpring.class)
				          .log(Level.FINER, "Unable to bind Web Service for [" + calledType.getCanonicalName() + "]. This is usually  because it is an internal one", e);
			}
		}
	}

	@Override
	protected void invoke(HttpServletRequest request, HttpServletResponse response) throws ServletException
	{
		HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper(request)
		{
			@Override
			public String getPathInfo()
			{
				return WSContext.baseWSUrl + super.getPathInfo();
			}
		};

		super.invoke(wrapper, response);
	}
}
