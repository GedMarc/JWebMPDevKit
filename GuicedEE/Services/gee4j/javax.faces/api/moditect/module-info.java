open module javax.faces {

	exports javax.faces.model;
	exports javax.faces.annotation;
	exports javax.faces.bean;
	exports javax.faces.application;
	exports javax.faces.component;
	exports javax.faces.component.behavior;
	exports javax.faces.component.html;
	exports javax.faces.component.search;
	exports javax.faces.component.visit;
	exports javax.faces.context;
	exports javax.faces.convert;
	exports javax.faces.el;
	exports javax.faces.event;
	exports javax.faces.flow;
	exports javax.faces.lifecycle;

	exports javax.faces.push;
	exports javax.faces.render;
	exports javax.faces.validator;
	exports javax.faces.view;
	exports javax.faces.view.facelets;
	exports javax.faces.webapp;
	exports javax.faces;

	exports com.sun.faces.config;

	requires java.logging;
	requires javax.servlet.api;
	requires java.xml;
	requires javax.el;
	//requires javax.servlet.jsp.jstl;
	requires javax.servlet.jsp.jstl.api;
	requires java.sql;
	requires static java.naming;
	requires static java.desktop;
	requires javax.servlet.jsp;
	requires javax.inject;
	requires jakarta.enterprise.cdi;
	requires static java.persistence;
	requires java.validation;
	requires javax.ejb;
	requires java.annotation;
	requires java.json;
	requires javax.websocket.api;

	requires java.xml.bind;
	requires javax.servlet.jsp.api;

	provides javax.enterprise.inject.spi.Extension with com.sun.faces.application.view.ViewScopeExtension,
			                                               com.sun.faces.flow.FlowCDIExtension,
			                                               com.sun.faces.flow.FlowDiscoveryCDIExtension,
			                                               com.sun.faces.cdi.CdiExtension;

	provides javax.servlet.ServletContainerInitializer with com.sun.faces.config.FacesInitializer;

	uses com.sun.faces.util.cdi11.CDIUtil;

	uses com.sun.faces.spi.FacesConfigResourceProvider;
	uses com.sun.faces.spi.AnnotationProvider;
	uses com.sun.faces.spi.ConfigurationResourceProvider;
	uses com.sun.faces.spi.DiscoverableInjectionProvider;
	uses com.sun.faces.spi.FaceletConfigResourceProvider;
	uses com.sun.faces.spi.InjectionProvider;
	uses com.sun.faces.spi.SerializationProvider;
	uses javax.faces.application.ApplicationConfigurationPopulator;


}
