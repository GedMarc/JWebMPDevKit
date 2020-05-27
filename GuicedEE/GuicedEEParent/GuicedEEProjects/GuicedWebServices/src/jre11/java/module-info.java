module com.guicedee.guicedservlets.webservices {
	exports com.guicedee.guicedservlets.webservices;

	requires com.guicedee.guicedservlets.undertow;
	requires org.apache.cxf;
	requires java.jws;

	provides com.guicedee.guicedservlets.services.IGuiceSiteBinder with com.guicedee.guicedservlets.webservices.implementations.WebServiceServletModule;
	provides com.guicedee.guicedinjection.interfaces.IGuiceConfigurator with com.guicedee.guicedservlets.webservices.implementations.WebServiceScannerConfig;
	provides com.guicedee.guicedservlets.undertow.services.UndertowDeploymentConfigurator with com.guicedee.guicedservlets.webservices.implementations.JaxWSUndertowDeploymentConfigurator;

	opens com.guicedee.guicedservlets.webservices.implementations to com.google.guice;
	opens com.guicedee.guicedservlets.webservices to com.google.guice;
}
