module jakarta.enterprise.cdi {
	requires transitive jakarta.enterprise.interceptor;
	requires transitive javax.inject;
	requires transitive javax.el;

	exports javax.decorator;
	exports javax.enterprise.context;
	exports javax.enterprise.context.control;
	exports javax.enterprise.context.spi;

	exports javax.enterprise.event;
	exports javax.enterprise.inject;
	exports javax.enterprise.inject.literal;
	exports javax.enterprise.inject.se;
	exports javax.enterprise.inject.spi;

	exports javax.enterprise.util;

	uses javax.enterprise.inject.spi.Extension;
	uses javax.enterprise.inject.se.SeContainerInitializer;
	uses javax.enterprise.inject.spi.CDIProvider;

}
