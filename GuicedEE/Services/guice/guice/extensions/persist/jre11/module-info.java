module com.google.guice.extensions.persist {
	exports com.google.inject.persist;

	requires com.google.guice;

	requires com.google.common;

	requires static javax.servlet.api;
	requires static aopalliance;

	requires javax.inject;

	//Test Dependencies
	requires java.sql;
	requires static java.logging;
	requires static java.naming;

	requires java.xml.bind;
	requires java.persistence;
}
