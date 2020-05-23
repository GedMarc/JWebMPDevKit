module com.google.guice.extensions.servlet {
	exports com.google.inject.servlet;

	//Servlet 4.0.3
	requires transitive java.servlet;

	requires transitive com.google.guice;
	requires java.logging;

	opens com.google.inject.servlet to com.google.guice;
}
