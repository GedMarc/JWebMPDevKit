module com.google.common {
	requires transitive java.logging;

	requires static java.compiler;

	requires transitive jakarta.activation;
	requires static jdk.unsupported;
}
