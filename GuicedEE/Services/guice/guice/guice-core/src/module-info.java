module com.google.guice {
	requires com.google.common;
	requires javax.inject;
	requires java.logging;
	requires static org.apache.commons.lang3;

	requires aopalliance;
	requires java.xml;

//	requires static cglib;
	requires static org.objectweb.asm;
}
