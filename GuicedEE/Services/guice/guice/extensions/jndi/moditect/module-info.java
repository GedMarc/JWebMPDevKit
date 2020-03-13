module com.google.guice.extensions.jndi {
	exports com.google.inject.jndi;

	requires com.google.guice;
	requires javax.inject;

	requires java.naming;
}
