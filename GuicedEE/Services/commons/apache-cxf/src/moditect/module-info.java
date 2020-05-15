module org.apache.cxf {

	requires transitive com.fasterxml.jackson.databind;
	requires transitive com.fasterxml.jackson.jaxrs.json;
	requires transitive javax.servlet.api;

	requires com.google.common;

	requires java.annotation;
	requires static java.management;
	requires java.logging;
	requires static java.desktop;
	requires static java.validation;
	requires java.jws;
	requires java.rmi;
	requires static org.slf4j;

	requires java.ws.rs;
	requires java.xml.ws;

	requires org.codehaus.stax2;

	exports org.apache.cxf.phase;
	exports org.apache.cxf.interceptor;
	exports org.apache.cxf.message;

	exports org.apache.cxf.service;
	exports org.apache.cxf.service.invoker;
	exports org.apache.cxf.jaxrs.ext;
	exports org.apache.cxf.jaxrs;
	exports org.apache.cxf.jaxrs.utils;
	exports org.apache.cxf;
	exports org.apache.cxf.frontend;
	exports org.apache.cxf.binding;
	exports org.apache.cxf.jaxrs.client;
	exports org.apache.cxf.jaxrs.lifecycle;
	exports org.apache.cxf.transport.servlet;
	exports org.apache.cxf.jaxrs.servlet;
	exports org.apache.cxf.jaxrs.impl;
	exports org.apache.cxf.jaxrs.validation;
	exports org.apache.cxf.binding.soap;
	exports org.apache.cxf.headers;
	exports org.apache.cxf.ws.security.wss4j;
	exports org.apache.wss4j.dom.handler;
	exports org.apache.wss4j.common.ext;

	exports org.apache.cxf.transport.servlet.servicelist;

	opens org.apache.cxf.rs.security.oauth2.services;
	opens org.apache.cxf.rs.security.oauth.services;

	exports org.apache.cxf.transport.http_undertow;
	exports org.glassfish.jersey.internal to java.ws.rs;

	//Filters and Providers
	opens org.apache.cxf.jaxrs.provider.json to com.google.guice;
	opens org.apache.cxf.jaxrs.provider.xmlbeans to com.google.guice;
	opens org.apache.cxf.jaxrs.provider to com.google.guice;
	opens org.apache.cxf.jaxrs.ext.search to com.google.guice;
	opens org.apache.cxf.jaxrs.validation to com.google.guice;
	opens org.apache.cxf.rs.security.oauth2.provider to com.google.guice;
	opens org.apache.cxf.jaxrs.provider.aegis to com.google.guice;
	opens org.apache.cxf.rs.security.oauth.filters to com.google.guice;
	opens org.apache.cxf.rs.security.oauth2.filters to com.google.guice;


	opens org.apache.cxf.rs.security.oauth2.common;
	opens org.apache.cxf.rs.security.oauth2.client;

	uses javax.ws.rs.ext.MessageBodyWriter;
	uses javax.ws.rs.ext.MessageBodyReader;
	uses javax.ws.rs.ext.ExceptionMapper;
	uses javax.ws.rs.ext.ContextResolver;
	uses javax.ws.rs.ext.ReaderInterceptor;
	uses javax.ws.rs.ext.WriterInterceptor;
	uses javax.ws.rs.ext.ParamConverterProvider;
	uses javax.ws.rs.container.ContainerRequestFilter;
	uses javax.ws.rs.container.ContainerResponseFilter;
	uses javax.ws.rs.container.DynamicFeature;
	uses org.apache.cxf.jaxrs.ext.ContextResolver;

	opens org.glassfish.jersey.server.wadl.internal;

	provides javax.xml.ws.spi.Provider with org.apache.cxf.jaxws.spi.ProviderImpl;

}
