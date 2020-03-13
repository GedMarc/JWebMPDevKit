module com.google.guice.extensions.persist {
	exports com.google.inject.persist;

	requires transitive com.google.guice;
	requires transitive java.persistence;
	requires transitive java.sql;

	requires static javax.servlet.api;
	requires static hibernate.jpa;

	opens com.google.inject.persist to com.google.guice;
	opens com.google.inject.persist.finder to com.google.guice;
	opens com.google.inject.persist.jpa to com.google.guice;

	//Test Dependencies
	requires static java.naming;
}
