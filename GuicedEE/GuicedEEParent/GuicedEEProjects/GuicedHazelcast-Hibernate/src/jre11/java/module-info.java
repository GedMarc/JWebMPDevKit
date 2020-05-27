module com.guicedee.guicedhazelcast.hibernate {
	exports com.guicedee.guicedhazelcast.hibernate;

	requires transitive com.guicedee.guicedhazelcast;
	requires com.hazelcast.hibernate;

	requires transitive com.guicedee.guicedpersistence;
	requires transitive org.hibernate.orm.jcache;

	provides com.guicedee.guicedpersistence.services.IPropertiesEntityManagerReader with com.guicedee.guicedhazelcast.hibernate.HazelcastHibernateProperties;

	opens com.guicedee.guicedhazelcast.hibernate to com.google.guice;
}
