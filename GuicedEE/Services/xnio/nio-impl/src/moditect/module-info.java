module xnio {
	exports org.xnio.nio;
	requires xnio.api;
	requires org.jboss.logging;
	requires java.compiler;

	provides org.xnio.XnioProvider with org.xnio.nio.NioXnioProvider;
}