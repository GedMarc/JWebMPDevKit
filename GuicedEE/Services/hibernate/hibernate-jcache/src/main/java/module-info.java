module org.hibernate.orm.jcache {
	requires transitive org.hibernate.orm.core;
	requires transitive org.hibernate.commons.annotations;
	requires transitive cache.api;

	requires transitive java.validation;
	requires transitive javax.inject;
	requires transitive java.transaction;
	requires transitive java.persistence;
	requires transitive java.xml.bind;

//	opens org.hibernate.cache.jcache.internal to org.hibernate.orm.core;

	//provides org.hibernate.boot.registry.selector.StrategyRegistrationProvider with org.hibernate.cache.jcache.internal.StrategyRegistrationProviderImpl;
}
