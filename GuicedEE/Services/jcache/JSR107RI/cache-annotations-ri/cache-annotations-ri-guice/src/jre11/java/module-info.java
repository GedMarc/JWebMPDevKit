module cache.annotations.ri.guice {
	requires com.google.guice;

	requires aopalliance;
	requires cache.annotations.ri.common;
	requires cache.api;
	requires javax.inject;

	exports org.jsr107.ri.annotations.guice.module;

	opens org.jsr107.ri.annotations.guice.module to com.google.guice;
	opens org.jsr107.ri.annotations.guice to com.google.guice;
}