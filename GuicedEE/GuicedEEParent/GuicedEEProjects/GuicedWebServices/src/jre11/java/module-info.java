module com.guicedee.guicedservlets.webservices {
	exports com.guicedee.guicedservlets.webservices;

	requires undertow.servlet;
	requires javax.servlet.api;
	requires com.guicedee.guicedservlets;

	requires jakarta.activation;

	//requires java.ws.rs;

	requires aopalliance;
	requires com.google.common;
	requires javax.inject;
	requires org.apache.cxf;

	requires java.xml.ws;
	requires java.jws;
	requires io.github.classgraph;
	requires com.fasterxml.jackson.databind;
	requires java.validation;

	provides com.guicedee.guicedservlets.services.IGuiceSiteBinder with com.guicedee.guicedservlets.webservices.implementations.WebServiceServletModule;
	provides com.guicedee.guicedinjection.interfaces.IGuiceConfigurator with com.guicedee.guicedservlets.webservices.implementations.WebServiceScannerConfig;

	opens  com.guicedee.guicedservlets.webservices.implementations to com.google.guice;
	opens  com.guicedee.guicedservlets.webservices to com.google.guice;
}
