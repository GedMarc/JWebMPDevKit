module com.hazelcast.all {
	requires java.logging;
	requires cache.api;
	requires java.transaction.xa;
	requires static java.management;

	requires java.xml;
	requires static org.hibernate.orm.core;
}
