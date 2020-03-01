module org.apache.logging.log4j.core {
	//annotation processing
	requires static java.compiler;
	requires java.desktop;
	requires static java.scripting;
	requires static java.management;
	requires static java.sql;
	requires static java.naming;
	requires static java.rmi;
	requires static jdk.unsupported;
	requires static com.fasterxml.jackson.core;
	requires static com.fasterxml.jackson.databind;
	requires static jakarta.mail;
	requires static com.fasterxml.jackson.dataformat.xml;

	requires static jakarta.activation;
	requires static org.apache.commons.compress;
	requires static org.apache.commons.csv;
	requires static org.codehaus.stax2;

	exports org.apache.logging.log4j.core;
	exports org.apache.logging.log4j.core.appender;
	exports org.apache.logging.log4j.core.appender.db;
	exports org.apache.logging.log4j.core.appender.db.jdbc;
	exports org.apache.logging.log4j.core.appender.nosql;
	exports org.apache.logging.log4j.core.appender.rewrite;
	exports org.apache.logging.log4j.core.appender.rolling;
	exports org.apache.logging.log4j.core.appender.rolling.action;
	exports org.apache.logging.log4j.core.appender.routing;
	exports org.apache.logging.log4j.core.async;
	exports org.apache.logging.log4j.core.config;
	exports org.apache.logging.log4j.core.config.composite;
	exports org.apache.logging.log4j.core.config.json;
	exports org.apache.logging.log4j.core.config.plugins;
	exports org.apache.logging.log4j.core.config.properties;
	exports org.apache.logging.log4j.core.config.status;
	exports org.apache.logging.log4j.core.config.xml;
	exports org.apache.logging.log4j.core.filter;
	exports org.apache.logging.log4j.core.impl;
	exports org.apache.logging.log4j.core.jackson;
	exports org.apache.logging.log4j.core.jmx;
	exports org.apache.logging.log4j.core.layout;
	exports org.apache.logging.log4j.core.lookup;
	exports org.apache.logging.log4j.core.message;
	exports org.apache.logging.log4j.core.net;
	exports org.apache.logging.log4j.core.parser;
	exports org.apache.logging.log4j.core.pattern;
	exports org.apache.logging.log4j.core.script;
	exports org.apache.logging.log4j.core.selector;
	exports org.apache.logging.log4j.core.time;
	exports org.apache.logging.log4j.core.tools;
	//exports org.apache.logging.log4j.core.util;

	exports org.apache.logging.log4j;
	exports org.apache.logging.log4j.jul;
	exports org.apache.logging.log4j.message;
	exports org.apache.logging.log4j.simple;
	exports org.apache.logging.log4j.spi;
	exports org.apache.logging.log4j.status;
	exports org.apache.logging.log4j.util;

	provides javax.annotation.processing.Processor with org.apache.logging.log4j.core.config.plugins.processor.PluginProcessor;
	provides org.apache.logging.log4j.message.ThreadDumpMessage.ThreadInfoFactory with org.apache.logging.log4j.core.message.ExtendedThreadInfoFactory;
	provides org.apache.logging.log4j.spi.Provider with org.apache.logging.log4j.core.impl.Log4jProvider;

	uses org.apache.logging.log4j.spi.Provider;
}
