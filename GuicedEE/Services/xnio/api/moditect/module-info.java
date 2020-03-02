module xnio.api {
	exports org.xnio;
	exports org.xnio.management;
	exports org.xnio.channels;
	//exports org.xnio.fc;
	exports org.xnio.conduits;
	exports org.xnio.ssl;
	exports org.xnio.http;


	requires static java.management;
	requires static java.security.sasl;
	requires org.jboss.logging;

	requires java.logging;
	requires static java.compiler;

	opens org.xnio._private to org.jboss.logging;

	uses org.xnio.XnioProvider;
}
