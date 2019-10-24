module org.hibernate.orm.core {
	requires java.sql;
	requires java.naming;
	requires java.transaction;
	requires java.persistence;

	requires org.hibernate.commons.annotations;
	requires org.jboss.logging;
	requires jandex;
	requires com.fasterxml.classmate;
	requires javassist;
	requires static antlr;
	requires java.xml.bind;
	requires java.desktop;
	requires net.bytebuddy;
	requires java.instrument;
	requires java.management;
	requires dom4j;

	requires static java.compiler;

	requires static jakarta.enterprise.cdi;
	requires java.validation;
	requires javax.inject;

	requires jdk.unsupported;

	requires static ant;
	requires static javax.security.jacc.api;

}