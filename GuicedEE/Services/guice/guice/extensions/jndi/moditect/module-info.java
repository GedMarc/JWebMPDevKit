module com.google.guice.extensions.jndi {
	exports com.google.inject.jndi;

	requires com.google.guice;
	requires javax.inject;

	requires static java.naming;

	opens com.google.inject.jndi to com.google.guice;
}
