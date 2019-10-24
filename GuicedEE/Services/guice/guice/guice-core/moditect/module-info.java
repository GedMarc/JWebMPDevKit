module com.google.guice {
	exports com.google.inject;
	exports com.google.inject.util;
	exports com.google.inject.matcher;
	exports com.google.inject.name;
	exports com.google.inject.binder;
	exports com.google.inject.spi;
	exports com.google.inject.multibindings;

	exports com.google.inject.internal.cglib.core;
	exports com.google.inject.internal.cglib.proxy;
	exports com.google.inject.internal.cglib.reflect;

	exports com.google.inject.internal;
	exports com.google.inject.internal.util;

	requires com.google.common;
	requires javax.inject;
	requires java.logging;
	requires static org.apache.commons.lang3;

	requires aopalliance;
	requires java.xml;

	requires static cglib;
	requires static org.objectweb.asm;
}
