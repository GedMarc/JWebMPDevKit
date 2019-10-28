module undertow.servlet {
	requires javax.servlet.api;

	requires undertow.core;
	requires java.annotation;

	requires static jdk.unsupported;

	requires xnio.api;
	requires org.jboss.logging;
}