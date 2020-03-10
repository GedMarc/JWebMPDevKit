module com.hazelcast.all {
	requires java.logging;
	requires transitive cache.api;
	requires java.transaction.xa;
	requires static java.management;

	requires transitive java.xml;
}
