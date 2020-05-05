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
}
