module xnio.api {
	exports org.xnio;
	exports org.xnio.management;
	exports org.xnio.channels;
	//exports org.xnio.fc;
	exports org.xnio.conduits;
	exports org.xnio.ssl;
	exports org.xnio.http;


	requires java.management;
	requires java.security.sasl;
	requires org.jboss.logging;

	requires java.logging;
	requires java.compiler;

	opens  org.xnio._private to org.jboss.logging;

	uses org.xnio.XnioProvider;
}