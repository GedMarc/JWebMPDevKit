module com.google.guice.extensions.servlet {
	exports com.google.inject.servlet;

	//Servlet 3.1
	requires static javax.servlet.api;
	//Servlet 2.5
	requires static servlet.api;
	requires transitive com.google.guice;

    opens com.google.inject.servlet to com.google.guice;

	requires java.logging;
	requires transitive javax.inject;
}
