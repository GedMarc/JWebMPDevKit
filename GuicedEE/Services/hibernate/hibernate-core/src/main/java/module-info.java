module org.hibernate.orm.core {
	requires transitive java.sql;
	requires static java.naming;
	requires java.transaction;
	requires java.persistence;

	requires org.hibernate.commons.annotations;
	requires org.jboss.logging;
	requires jandex;
	requires com.fasterxml.classmate;
	requires javassist;
	requires static antlr;
	requires java.xml.bind;
	requires static java.desktop;
	requires net.bytebuddy;
	requires static  java.instrument;
	requires static java.management;
	requires dom4j;

	requires static java.compiler;

	requires static jakarta.enterprise.cdi;
	requires java.validation;
	requires javax.inject;

	requires static jdk.unsupported;

	requires static ant;
	requires static javax.security.jacc.api;

}
