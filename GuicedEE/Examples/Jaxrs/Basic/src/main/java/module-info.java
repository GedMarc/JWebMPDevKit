import com.guicedee.examples.jaxrs.basic.RestBinding;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;

module com.guicedee.examples.jaxrs.basic {
	requires com.guicedee.guicedservlets.rest;
	requires com.guicedee.guicedservlets.undertow;
	requires java.net.http;

	provides IGuiceModule with RestBinding;

	opens com.guicedee.examples.jaxrs.basic.resources to com.google.guice, com.fasterxml.jackson.databind, org.apache.cxf;
}
