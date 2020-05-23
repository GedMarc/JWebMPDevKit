module undertow.core {

	requires org.jboss.logging;

	requires static java.security.jgss;

	requires static alpn.api;
	requires static io.undertow.parser.generator;
	requires static jdk.unsupported;
	requires static java.naming;
	requires static java.sql;
	requires static java.compiler;
}
