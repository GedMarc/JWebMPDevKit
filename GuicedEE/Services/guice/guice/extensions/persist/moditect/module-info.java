module com.google.guice.extensions.persist {
	exports com.google.inject.persist;

	requires transitive com.google.guice;
	requires transitive java.persistence;
	requires transitive java.sql;

	requires static javax.servlet.api;
	requires static hibernate.jpa;

	//Test Dependencies
	requires static java.naming;
}
