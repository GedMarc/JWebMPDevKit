module undertow.websockets.jsr {
	requires javax.websocket.api;
	requires undertow.servlet;

	requires undertow.core;
	requires xnio.api;
	requires javax.servlet.api;
	requires org.jboss.logging;
	requires java.annotation;
}