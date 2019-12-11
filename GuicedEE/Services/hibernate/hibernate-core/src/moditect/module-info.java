module org.hibernate.orm.core {
	requires java.sql;
	requires java.naming;
	requires java.transaction;
	requires java.persistence;

	requires org.hibernate.commons.annotations;
	requires org.jboss.logging;
	requires jandex;
	requires com.fasterxml.classmate;
	requires javassist;
	requires static antlr;
	requires java.xml.bind;
	requires java.desktop;
	requires net.bytebuddy;
	requires java.instrument;
	requires java.management;
	requires dom4j;

	requires static java.compiler;

	requires static jakarta.enterprise.cdi;
	requires java.validation;
	requires javax.inject;

	requires jdk.unsupported;

	requires static ant;
	requires static javax.security.jacc.api;

	uses org.hibernate.boot.registry.selector.StrategyRegistrationProvider;
	uses org.hibernate.boot.registry.selector.spi.StrategyCreator;
	uses org.hibernate.boot.registry.selector.spi.StrategySelector;

	uses org.hibernate.boot.model.TypeContributor;
	uses org.hibernate.boot.model.IdGeneratorStrategyInterpreter;

	opens org.hibernate.internal to org.jboss.logging;
	opens org.hibernate.internal.log to org.jboss.logging;
	opens org.hibernate.resource.beans.internal to org.jboss.logging;
	opens org.hibernate.internal.util.xml to org.jboss.logging;
	opens org.hibernate.engine.jdbc.spi to org.jboss.logging;
	opens org.hibernate.cache.spi to org.jboss.logging;
	opens org.hibernate.bytecode to org.jboss.logging;


	exports org.hibernate;
	//exports org.hibernate.action.internal;
	exports org.hibernate.action.spi;
	//exports org.hibernate.internal;
	//exports org.hibernate.internal.build;
	//exports org.hibernate.internal.log;
	//exports org.hibernate.internal.util;
	//exports org.hibernate.internal.util.beans;
	//exports org.hibernate.internal.util.collections;
	//exports org.hibernate.internal.util.compare;
	//exports org.hibernate.internal.util.config;
	//exports org.hibernate.internal.util.io;
	//exports org.hibernate.internal.util.jndi;
	//exports org.hibernate.internal.util.type;
	//exports org.hibernate.internal.util.xml;
	exports org.hibernate.annotations;
	exports org.hibernate.boot;
	//exports org.hibernate.boot.internal;
	//exports org.hibernate.boot.archive.internal;
	exports org.hibernate.boot.archive.scan.spi;
	//exports org.hibernate.boot.archive.scan.internal;
	exports org.hibernate.boot.archive.spi;
	//exports org.hibernate.boot.cfgxml.internal;
	exports org.hibernate.boot.cfgxml.spi;
	exports org.hibernate.boot.jaxb;
	//exports org.hibernate.boot.jaxb.internal;
	//exports org.hibernate.boot.jaxb.hbm.internal;
	exports org.hibernate.boot.jaxb.hbm.spi;
	exports org.hibernate.boot.jaxb.spi;
	exports org.hibernate.boot.model;
	//exports org.hibernate.boot.model.convert.internal;
	exports org.hibernate.boot.model.convert.spi;
	exports org.hibernate.boot.model.naming;
	//exports org.hibernate.boot.model.process.internal;
	exports org.hibernate.boot.model.process.spi;
	exports org.hibernate.boot.model.relational;
	//exports org.hibernate.boot.model.source.internal;
	//exports org.hibernate.boot.model.source.internal.annotations;
	exports org.hibernate.boot.model.source.internal.hbm;
	exports org.hibernate.boot.model.source.spi;

	exports org.hibernate.boot.registry;
	//exports org.hibernate.boot.registry.internal;
	//exports org.hibernate.boot.registry.classloading.internal;
	exports org.hibernate.boot.registry.classloading.spi;
	exports org.hibernate.boot.registry.selector;
	//exports org.hibernate.boot.registry.selector.internal;
	exports org.hibernate.boot.registry.selector.spi;
	exports org.hibernate.boot.spi;
	exports org.hibernate.boot.xsd;
	exports org.hibernate.bytecode;
	exports org.hibernate.bytecode.spi;
/*	exports org.hibernate.bytecode.internal.bytebuddy;
	exports org.hibernate.bytecode.internal.javassist;*/
	//exports org.hibernate.bytecode.enhance;
	exports org.hibernate.bytecode.enhance.spi;
	exports org.hibernate.bytecode.enhance.spi.interceptor;
	//exports org.hibernate.bytecode.enhance.internal;
/*
	exports org.hibernate.bytecode.enhance.internal.bytebuddy;
	exports org.hibernate.bytecode.enhance.internal.javassist;
	exports org.hibernate.bytecode.enhance.internal.tracker;
*/

	exports org.hibernate.cache;
	exports org.hibernate.cache.spi;
	exports org.hibernate.cache.spi.access;
	exports org.hibernate.cache.spi.entry;
	exports org.hibernate.cache.spi.support;
	//exports org.hibernate.cache.internal;
	//exports org.hibernate.cache.cfg;
	exports org.hibernate.cache.cfg.spi;
	//exports org.hibernate.cache.cfg.internal;

	exports org.hibernate.cfg;
	exports org.hibernate.cfg.annotations;
	exports org.hibernate.cfg.annotations.reflection;
	exports org.hibernate.cfg.beanvalidation;
	exports org.hibernate.classic;

	exports org.hibernate.collection.spi;
	//exports org.hibernate.collection.internal;
	exports org.hibernate.context;
	exports org.hibernate.context.spi;
	//exports org.hibernate.context.internal;

	exports org.hibernate.criterion;
	exports org.hibernate.dialect;
	exports org.hibernate.dialect.function;
	exports org.hibernate.dialect.hint;
	exports org.hibernate.dialect.identity;
	exports org.hibernate.dialect.lock;
	exports org.hibernate.dialect.pagination;
	exports org.hibernate.dialect.unique;

	exports org.hibernate.ejb;
	exports org.hibernate.engine;
	exports org.hibernate.engine.spi;
	//exports org.hibernate.engine.internal;
	exports org.hibernate.engine.config.spi;
	//exports org.hibernate.engine.config.internal;
	exports org.hibernate.engine.jdbc;
	exports org.hibernate.engine.jdbc.spi;
	//exports org.hibernate.engine.jdbc.internal;
	exports org.hibernate.engine.jdbc.batch.spi;
//	exports org.hibernate.engine.jdbc.batch.internal;
	exports org.hibernate.engine.jdbc.connections.spi;
	//exports org.hibernate.engine.jdbc.connections.internal;
	exports org.hibernate.engine.jdbc.cursor.spi;
//	exports org.hibernate.engine.jdbc.cursor.internal;
	exports org.hibernate.engine.jdbc.dialect.spi;
//	exports org.hibernate.engine.jdbc.dialect.internal;
	exports org.hibernate.engine.jdbc.env.spi;
//	exports org.hibernate.engine.jdbc.env.internal;
	exports org.hibernate.engine.jndi.spi;
//	exports org.hibernate.engine.jndi.internal;
//	exports org.hibernate.engine.loading.internal;
	exports org.hibernate.engine.profile;
	exports org.hibernate.engine.query.spi;
//	exports org.hibernate.engine.query.internal;
	exports org.hibernate.engine.transaction.spi;
//	exports org.hibernate.engine.transaction.internal.jta;
	exports org.hibernate.engine.transaction.jta.platform.spi;
	exports org.hibernate.engine.transaction.jta.platform.internal;
	exports org.hibernate.event.spi;
//	exports org.hibernate.event.internal;
	exports org.hibernate.event.service.spi;
//	exports org.hibernate.event.service.internal;
	exports org.hibernate.exception;
	exports org.hibernate.exception.spi;
//	exports org.hibernate.exception.internal;
	exports org.hibernate.graph.spi;
	exports org.hibernate.hql.spi;
//	exports org.hibernate.hql.internal;

	//exports org.hibernate.hql.internal.classic;
	//exports org.hibernate.hql.internal.ast.exec;
	//exports org.hibernate.hql.internal.ast.tree;
	//exports org.hibernate.hql.internal.ast.util;
	exports org.hibernate.id;
	exports org.hibernate.id.enhanced;
	exports org.hibernate.id.factory;
	exports org.hibernate.id.factory.spi;
	exports org.hibernate.id.factory.internal;
	exports org.hibernate.id.insert;
	exports org.hibernate.id.uuid;
	//exports org.hibernate.integrator.spi;
	//exports org.hibernate.integrator.internal;
	exports org.hibernate.jdbc;
	exports org.hibernate.jmx.spi;
	//exports org.hibernate.jmx.internal;
	exports org.hibernate.jpa;
	//exports org.hibernate.jpa.graph.internal;
	exports org.hibernate.jpa.event.spi;
	//exports org.hibernate.jpa.event.internal;
	exports org.hibernate.jpa.spi;
	//exports org.hibernate.jpa.internal;
	//exports org.hibernate.jpa.internal.enhance;
	//exports org.hibernate.jpa.internal.util;
	exports org.hibernate.jpa.boot.spi;
//	exports org.hibernate.jpa.boot.internal;

	//exports org.hibernate.loader;
	//exports org.hibernate.loader.hql;
	exports org.hibernate.loader.spi;
	//exports org.hibernate.loader.internal;
//	exports org.hibernate.loader.collection;
	//exports org.hibernate.loader.collection.plan;
	//exports org.hibernate.loader.criteria;
	//exports org.hibernate.loader.custom;
	//exports org.hibernate.loader.custom.sql;
	//exports org.hibernate.loader.entity;
	//exports org.hibernate.loader.entity.plan;
	exports org.hibernate.loader.plan.spi;
	exports org.hibernate.loader.plan.build.spi;
	//exports org.hibernate.loader.plan.build.internal;
	//exports org.hibernate.loader.plan.build.internal.returns;
	//exports org.hibernate.loader.plan.build.internal.spaces;
	exports org.hibernate.loader.plan.exec.query.spi;
	//exports org.hibernate.loader.plan.exec.query.internal;
	exports org.hibernate.loader.plan.exec.spi;
	//exports org.hibernate.loader.plan.exec.internal;
	exports org.hibernate.loader.plan.exec.process.spi;
	//exports org.hibernate.loader.plan.exec.process.internal;

	exports org.hibernate.lob;
	exports org.hibernate.mapping;
	exports org.hibernate.metadata;
	exports org.hibernate.metamodel.spi;
	//exports org.hibernate.metamodel.internal;
	exports org.hibernate.metamodel.model.convert.spi;
	//exports org.hibernate.metamodel.model.convert.internal;
	exports org.hibernate.metamodel.model.domain;
	exports org.hibernate.param;
	exports org.hibernate.persister.spi;
	//exports org.hibernate.persister.internal;
	exports org.hibernate.persister.collection;
	exports org.hibernate.persister.entity;
	exports org.hibernate.persister.walking.spi;
	//exports org.hibernate.persister.walking.internal;

	exports org.hibernate.proxy;
	exports org.hibernate.pretty;
	exports org.hibernate.procedure;
	exports org.hibernate.procedure.spi;
	//exports org.hibernate.procedure.internal;
	exports org.hibernate.property.access.spi;
	//exports org.hibernate.property.access.internal;
/*
	exports org.hibernate.proxy.map;
	exports org.hibernate.proxy.pojo;
	exports org.hibernate.proxy.pojo.bytebuddy;
	exports org.hibernate.proxy.pojo.javassist;
	exports org.hibernate.resource.transaction;*/
	exports org.hibernate.resource.transaction.spi;
	//exports org.hibernate.resource.transaction.internal;
	exports org.hibernate.resource.transaction.backend.jdbc.spi;
	//exports org.hibernate.resource.transaction.backend.jdbc.internal;
	//exports org.hibernate.resource.transaction.backend.jta.internal.synchronization;
//	exports org.hibernate.resource.transaction.backend.jta.internal;
	//exports org.hibernate.resource.jdbc.internal;
	exports org.hibernate.resource.jdbc.spi;
	exports org.hibernate.resource.jdbc;
	exports org.hibernate.result;
	//exports org.hibernate.result.internal;
	exports org.hibernate.result.spi;
	//exports org.hibernate.secure.internal;
	exports org.hibernate.secure.spi;
	exports org.hibernate.sql;
	exports org.hibernate.sql.ordering.antlr;
	exports org.hibernate.stat;
//	exports org.hibernate.stat.internal;
/*	exports org.hibernate.stat.spi;
	exports org.hibernate.tool.enhance;
	exports org.hibernate.tool.hbm2ddl;
	exports org.hibernate.tool.instrument.javassist;*/
	//exports org.hibernate.tool.schema.internal.exec;
	//exports org.hibernate.tool.schema.internal;
/*	exports org.hibernate.tool.schema;
	exports org.hibernate.tool.schema.spi;
	exports org.hibernate.tool.schema.extract.internal;
	exports org.hibernate.tool.schema.extract.spi;*/
	exports org.hibernate.transform;
	exports org.hibernate.tuple;
	exports org.hibernate.tuple.component;
	exports org.hibernate.tuple.entity;
	exports org.hibernate.type;
//	exports org.hibernate.type.internal;
	exports org.hibernate.type.spi;
	exports org.hibernate.type.descriptor;
	exports org.hibernate.type.descriptor.spi;
	exports org.hibernate.type.descriptor.converter;
	exports org.hibernate.type.descriptor.java;
	exports org.hibernate.type.descriptor.java.spi;
	exports org.hibernate.type.descriptor.sql;
	exports org.hibernate.type.descriptor.sql.spi;
	exports org.hibernate.usertype;

	opens org.hibernate;
	opens org.hibernate.jpa;
	opens org.hibernate.xsd.cfg;
	opens org.hibernate.xsd.mapping;


	//exports org.hibernate.cache.internal;
	//exports org.hibernate.internal.util;

	uses org.hibernate.action.spi.AfterTransactionCompletionProcess;
	uses org.hibernate.action.spi.BeforeTransactionCompletionProcess;
	uses org.hibernate.action.spi.Executable;
	uses org.hibernate.boot.archive.spi.ArchiveContext;
	uses org.hibernate.boot.archive.spi.ArchiveDescriptor;
	uses org.hibernate.boot.archive.spi.ArchiveEntry;
	uses org.hibernate.boot.archive.spi.ArchiveEntryHandler;
	uses org.hibernate.boot.archive.spi.JarFileEntryUrlAdjuster;
	uses org.hibernate.boot.archive.spi.InputStreamAccess;
	uses org.hibernate.boot.jaxb.spi.Binder;
	uses org.hibernate.boot.jaxb.hbm.spi.SimpleValueTypeInfo;
	uses org.hibernate.boot.jaxb.hbm.spi.AttributeMapping;
	uses org.hibernate.boot.model.convert.spi.ConverterDescriptor;
	uses org.hibernate.boot.model.convert.spi.AutoApplicableConverterDescriptor;
	uses org.hibernate.boot.model.convert.spi.JpaAttributeConverterCreationContext;
	uses org.hibernate.boot.model.convert.spi.ConverterAutoApplyHandler;
	uses org.hibernate.boot.model.process.spi.ManagedResources;
	uses org.hibernate.boot.model.source.spi.RelationalValueSource;
	uses org.hibernate.boot.model.source.spi.AttributeSource;
	uses org.hibernate.boot.model.source.spi.AttributeSourceContainer;
	uses org.hibernate.boot.model.source.spi.ColumnSource;
	uses org.hibernate.boot.model.source.spi.HibernateTypeSource;
	uses org.hibernate.boot.model.source.spi.LocalMetadataBuildingContext;
	uses org.hibernate.boot.model.source.spi.EmbeddableMapping;
	uses org.hibernate.boot.model.source.spi.FilterSource;
	uses org.hibernate.boot.model.source.spi.SizeSource;
	uses org.hibernate.boot.model.source.spi.EmbeddableSource;
	uses org.hibernate.boot.model.source.spi.PluralAttributeSource;
	uses org.hibernate.boot.model.source.spi.RelationalValueSourceContainer;
	uses org.hibernate.boot.model.source.spi.TableSpecificationSource;
	uses org.hibernate.boot.model.source.spi.TableSource;
	uses org.hibernate.boot.model.source.spi.DerivedValueSource;
	uses org.hibernate.boot.model.source.spi.EntitySource;
	uses org.hibernate.boot.model.source.spi.AnyDiscriminatorSource;
	uses org.hibernate.boot.model.source.spi.AnyKeySource;
	uses org.hibernate.boot.model.source.spi.AnyMappingSource;
	uses org.hibernate.boot.model.source.spi.AssociationSource;
	uses org.hibernate.boot.model.source.spi.CascadeStyleSource;
	uses org.hibernate.boot.model.source.spi.CollectionIdSource;
	uses org.hibernate.boot.model.source.spi.ColumnBindingDefaults;
	uses org.hibernate.boot.model.source.spi.ColumnsAndFormulasSourceContainer;
	uses org.hibernate.boot.model.source.spi.CompositeIdentifierSource;
	uses org.hibernate.boot.model.source.spi.DiscriminatorSource;
	uses org.hibernate.boot.model.source.spi.EmbeddableSourceContributor;
	uses org.hibernate.boot.model.source.spi.EmbeddedAttributeMapping;
	uses org.hibernate.boot.model.source.spi.EntityHierarchySource;
	uses org.hibernate.boot.model.source.spi.EntityNamingSource;
	uses org.hibernate.boot.model.source.spi.EntityNamingSourceContributor;
	uses org.hibernate.boot.model.source.spi.FetchableAttributeSource;
	uses org.hibernate.boot.model.source.spi.FetchCharacteristics;
	uses org.hibernate.boot.model.source.spi.FetchCharacteristicsPluralAttribute;
	uses org.hibernate.boot.model.source.spi.FetchCharacteristicsSingularAssociation;
	uses org.hibernate.boot.model.source.spi.ForeignKeyContributingSource;
	uses org.hibernate.boot.model.source.spi.IdentifiableTypeSource;
	uses org.hibernate.boot.model.source.spi.IdentifierSource;
	uses org.hibernate.boot.model.source.spi.IdentifierSourceAggregatedComposite;
	uses org.hibernate.boot.model.source.spi.IdentifierSourceNonAggregatedComposite;
	uses org.hibernate.boot.model.source.spi.IdentifierSourceSimple;
	uses org.hibernate.boot.model.source.spi.InLineViewSource;
	uses org.hibernate.boot.model.source.spi.JavaTypeDescriptorResolvable;
	uses org.hibernate.boot.model.source.spi.JoinedSubclassEntitySource;
	uses org.hibernate.boot.model.source.spi.JpaCallbackSource;
	uses org.hibernate.boot.model.source.spi.MapsIdSource;
	uses org.hibernate.boot.model.source.spi.MetadataSourceProcessor;
	uses org.hibernate.boot.model.source.spi.MultiTenancySource;
	uses org.hibernate.boot.model.source.spi.Orderable;
	uses org.hibernate.boot.model.source.spi.PluralAttributeElementSource;
	uses org.hibernate.boot.model.source.spi.PluralAttributeElementSourceAssociation;
	uses org.hibernate.boot.model.source.spi.PluralAttributeElementSourceBasic;
	uses org.hibernate.boot.model.source.spi.PluralAttributeElementSourceEmbedded;
	uses org.hibernate.boot.model.source.spi.PluralAttributeElementSourceManyToAny;
	uses org.hibernate.boot.model.source.spi.PluralAttributeElementSourceManyToMany;
	uses org.hibernate.boot.model.source.spi.PluralAttributeElementSourceOneToMany;
	uses org.hibernate.boot.model.source.spi.PluralAttributeIndexSource;
	uses org.hibernate.boot.model.source.spi.PluralAttributeKeySource;
	uses org.hibernate.boot.model.source.spi.PluralAttributeMapKeyManyToAnySource;
	uses org.hibernate.boot.model.source.spi.PluralAttributeMapKeyManyToManySource;
	uses org.hibernate.boot.model.source.spi.PluralAttributeMapKeySource;
	uses org.hibernate.boot.model.source.spi.PluralAttributeMapKeySourceBasic;
	uses org.hibernate.boot.model.source.spi.PluralAttributeMapKeySourceEmbedded;
	uses org.hibernate.boot.model.source.spi.PluralAttributeSequentialIndexSource;
	uses org.hibernate.boot.model.source.spi.PluralAttributeSourceArray;
	uses org.hibernate.boot.model.source.spi.SecondaryTableSource;
	uses org.hibernate.boot.model.source.spi.SingularAttributeSource;
	uses org.hibernate.boot.model.source.spi.SingularAttributeSourceAny;
	uses org.hibernate.boot.model.source.spi.SingularAttributeSourceBasic;
	uses org.hibernate.boot.model.source.spi.SingularAttributeSourceEmbedded;
	uses org.hibernate.boot.model.source.spi.SingularAttributeSourceManyToOne;
	uses org.hibernate.boot.model.source.spi.SingularAttributeSourceOneToOne;
	uses org.hibernate.boot.model.source.spi.SingularAttributeSourceToOne;
	uses org.hibernate.boot.model.source.spi.Sortable;
	uses org.hibernate.boot.model.source.spi.SubclassEntitySource;
	uses org.hibernate.boot.model.source.spi.ToolingHintContextContainer;
	uses org.hibernate.boot.model.source.spi.VersionAttributeSource;

	uses org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
	uses org.hibernate.boot.spi.BootstrapContext;
	uses org.hibernate.boot.spi.ClassLoaderAccess;
	uses org.hibernate.boot.spi.InFlightMetadataCollector;
	uses org.hibernate.boot.spi.JpaOrmXmlPersistenceUnitDefaultAware;
	uses org.hibernate.boot.spi.MappingDefaults;
	uses org.hibernate.boot.spi.MetadataBuilderContributor;
	uses org.hibernate.boot.spi.MetadataBuilderFactory;
	uses org.hibernate.boot.spi.MetadataBuilderImplementor;
	uses org.hibernate.boot.spi.MetadataBuilderInitializer;
	uses org.hibernate.boot.spi.MetadataBuildingContext;
	uses org.hibernate.boot.spi.MetadataBuildingOptions;
	uses org.hibernate.boot.spi.XmlMappingBinderAccess;
	uses org.hibernate.boot.spi.MetadataContributor;
	uses org.hibernate.boot.spi.MetadataImplementor;
	uses org.hibernate.boot.spi.MetadataSourcesContributor;
	uses org.hibernate.boot.spi.NaturalIdUniqueKeyBinder;
	uses org.hibernate.boot.spi.SessionFactoryBuilderFactory;
	uses org.hibernate.boot.spi.SessionFactoryBuilderImplementor;
	uses org.hibernate.boot.spi.SessionFactoryOptions;
	uses org.hibernate.boot.spi.AdditionalJaxbMappingProducer;

	uses org.hibernate.bytecode.spi.BasicProxyFactory;
	uses org.hibernate.bytecode.spi.BytecodeEnhancementMetadata;
	uses org.hibernate.bytecode.spi.BytecodeProvider;
	uses org.hibernate.bytecode.spi.ClassTransformer;
	uses org.hibernate.bytecode.spi.ProxyFactoryFactory;
	uses org.hibernate.bytecode.spi.ReflectionOptimizer;

	uses org.hibernate.bytecode.enhance.spi.CollectionTracker;
	uses org.hibernate.bytecode.enhance.spi.EnhancementContext;
	uses org.hibernate.bytecode.enhance.spi.Enhancer;
	uses org.hibernate.bytecode.enhance.spi.LazyPropertyInitializer;
	uses org.hibernate.bytecode.enhance.spi.UnloadedClass;
	uses org.hibernate.bytecode.enhance.spi.UnloadedField;
	uses org.hibernate.bytecode.enhance.spi.interceptor.BytecodeLazyAttributeInterceptor;
	uses org.hibernate.bytecode.enhance.spi.interceptor.LazyFetchGroupMetadata;
	uses org.hibernate.bytecode.enhance.spi.interceptor.SessionAssociableInterceptor;

	uses org.hibernate.cache.spi.CacheImplementor;
	uses org.hibernate.cache.spi.CacheKeysFactory;
	uses org.hibernate.cache.spi.CacheTransactionSynchronization;
	uses org.hibernate.cache.spi.DirectAccessRegion;
	uses org.hibernate.cache.spi.DomainDataRegion;
	uses org.hibernate.cache.spi.ExtendedStatisticsSupport;
	uses org.hibernate.cache.spi.QueryResultsCache;
	uses org.hibernate.cache.spi.QueryResultsRegion;
	uses org.hibernate.cache.spi.Region;
	uses org.hibernate.cache.spi.RegionFactory;
	uses org.hibernate.cache.spi.SecondLevelCacheLogger;
	uses org.hibernate.cache.spi.TimestampsCache;
	uses org.hibernate.cache.spi.TimestampsCacheFactory;
	uses org.hibernate.cache.spi.TimestampsRegion;
	uses org.hibernate.cache.spi.QueryCache;
	uses org.hibernate.cache.spi.UpdateTimestampsCache;
	uses org.hibernate.cache.spi.access.CachedDomainDataAccess;
	uses org.hibernate.cache.spi.access.CollectionDataAccess;
	uses org.hibernate.cache.spi.access.EntityDataAccess;
	uses org.hibernate.cache.spi.access.NaturalIdDataAccess;
	uses org.hibernate.cache.spi.access.SoftLock;
	uses org.hibernate.cache.spi.entry.CacheEntry;
	uses org.hibernate.cache.spi.entry.CacheEntryStructure;
	uses org.hibernate.cache.spi.support.DomainDataStorageAccess;
	uses org.hibernate.cache.spi.support.StorageAccess;
	uses org.hibernate.cache.cfg.spi.CollectionDataCachingConfig;
	uses org.hibernate.cache.cfg.spi.DomainDataCachingConfig;
	uses org.hibernate.cache.cfg.spi.DomainDataRegionBuildingContext;
	uses org.hibernate.cache.cfg.spi.DomainDataRegionConfig;
	uses org.hibernate.cache.cfg.spi.EntityDataCachingConfig;
	uses org.hibernate.cache.cfg.spi.NaturalIdDataCachingConfig;
	uses org.hibernate.cfg.beanvalidation.ActivationContext;
	uses org.hibernate.collection.spi.PersistentCollection;
	uses org.hibernate.context.spi.CurrentSessionContext;
	uses org.hibernate.context.spi.CurrentTenantIdentifierResolver;
	uses org.hibernate.engine.spi.CascadeStyle;
	uses org.hibernate.engine.spi.CascadingAction;
	uses org.hibernate.engine.spi.CompositeOwner;
	uses org.hibernate.engine.spi.CompositeTracker;
	uses org.hibernate.engine.spi.EntityEntry;
	uses org.hibernate.engine.spi.EntityEntryExtraState;
	uses org.hibernate.engine.spi.EntityEntryFactory;
	uses org.hibernate.engine.spi.ExceptionConverter;
	uses org.hibernate.engine.spi.ExtendedSelfDirtinessTracker;
	uses org.hibernate.engine.spi.Managed;
	uses org.hibernate.engine.spi.ManagedComposite;
	uses org.hibernate.engine.spi.ManagedEntity;
	uses org.hibernate.engine.spi.ManagedMappedSuperclass;
	uses org.hibernate.engine.spi.Mapping;
	uses org.hibernate.engine.spi.PersistenceContext;
	uses org.hibernate.engine.spi.PersistentAttributeInterceptable;
	uses org.hibernate.engine.spi.PersistentAttributeInterceptor;
	uses org.hibernate.engine.spi.SelfDirtinessTracker;
	uses org.hibernate.engine.spi.SessionEventListenerManager;
	uses org.hibernate.engine.spi.SessionFactoryImplementor;
	uses org.hibernate.engine.spi.SessionImplementor;
	uses org.hibernate.engine.spi.SharedSessionContractImplementor;
	uses org.hibernate.engine.spi.UnsavedValueStrategy;
	uses org.hibernate.engine.spi.CacheImplementor;
	uses org.hibernate.engine.spi.SessionOwner;
	uses org.hibernate.engine.jdbc.spi.ConnectionObserver;
	uses org.hibernate.engine.jdbc.spi.InvalidatableWrapper;
	uses org.hibernate.engine.jdbc.spi.JdbcCoordinator;
	uses org.hibernate.engine.jdbc.spi.JdbcServices;
	uses org.hibernate.engine.jdbc.spi.JdbcWrapper;
	uses org.hibernate.engine.jdbc.spi.NonDurableConnectionObserver;
	uses org.hibernate.engine.jdbc.spi.ResultSetReturn;
	uses org.hibernate.engine.jdbc.spi.ResultSetWrapper;
	uses org.hibernate.engine.jdbc.spi.SchemaNameResolver;
	uses org.hibernate.engine.jdbc.spi.StatementPreparer;
	uses org.hibernate.engine.jdbc.dialect.spi.DialectFactory;
	uses org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
	uses org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfoSource;
	uses org.hibernate.engine.jdbc.dialect.spi.DialectResolver;
	uses org.hibernate.engine.jdbc.env.spi.ExtractedDatabaseMetaData;
	uses org.hibernate.engine.jdbc.env.spi.IdentifierHelper;
	uses org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
	uses org.hibernate.engine.jdbc.env.spi.LobCreatorBuilder;
	uses org.hibernate.engine.jdbc.env.spi.QualifiedObjectNameFormatter;
	uses org.hibernate.engine.jdbc.env.spi.SchemaNameResolver;
	uses org.hibernate.engine.jdbc.batch.spi.Batch;
	uses org.hibernate.engine.jdbc.batch.spi.BatchBuilder;
	uses org.hibernate.engine.jdbc.batch.spi.BatchKey;
	uses org.hibernate.engine.jdbc.batch.spi.BatchObserver;
	uses org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
	uses org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
	uses org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
	uses org.hibernate.engine.jdbc.cursor.spi.RefCursorSupport;
	uses org.hibernate.engine.transaction.spi.IsolationDelegate;
	uses org.hibernate.engine.transaction.spi.SynchronizationRegistry;
	uses org.hibernate.engine.transaction.spi.TransactionImplementor;
	uses org.hibernate.engine.transaction.spi.TransactionObserver;
	uses org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform;
	uses org.hibernate.engine.transaction.jta.platform.spi.JtaPlatformProvider;
	uses org.hibernate.engine.transaction.jta.platform.spi.JtaPlatformResolver;
	uses org.hibernate.engine.query.spi.NativeQueryInterpreter;
	uses org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;
	uses org.hibernate.engine.jndi.spi.JndiService;
	uses org.hibernate.engine.config.spi.ConfigurationService;
	uses org.hibernate.event.spi.AutoFlushEventListener;
	uses org.hibernate.event.spi.ClearEventListener;
	uses org.hibernate.event.spi.DeleteEventListener;
	uses org.hibernate.event.spi.DirtyCheckEventListener;
	uses org.hibernate.event.spi.EntityCopyObserver;
	uses org.hibernate.event.spi.EventSource;
	uses org.hibernate.event.spi.EvictEventListener;
	uses org.hibernate.event.spi.FlushEntityEventListener;
	uses org.hibernate.event.spi.FlushEventListener;
	uses org.hibernate.event.spi.InitializeCollectionEventListener;
	uses org.hibernate.event.spi.LoadEventListener;
	uses org.hibernate.event.spi.LockEventListener;
	uses org.hibernate.event.spi.MergeEventListener;
	uses org.hibernate.event.spi.PersistEventListener;
	uses org.hibernate.event.spi.PostCollectionRecreateEventListener;
	uses org.hibernate.event.spi.PostCollectionRemoveEventListener;
	uses org.hibernate.event.spi.PostCollectionUpdateEventListener;
	uses org.hibernate.event.spi.PostCommitDeleteEventListener;
	uses org.hibernate.event.spi.PostCommitInsertEventListener;
	uses org.hibernate.event.spi.PostInsertEventListener;
	uses org.hibernate.event.spi.PostCommitUpdateEventListener;
	uses org.hibernate.event.spi.PostUpdateEvent;
	uses org.hibernate.event.spi.PersistEvent;
	uses org.hibernate.event.spi.PostDeleteEvent;
	uses org.hibernate.event.spi.PostDeleteEventListener;
	uses org.hibernate.event.spi.PostLoadEventListener;
	uses org.hibernate.event.spi.PreCollectionRecreateEventListener;
	uses org.hibernate.event.spi.PostUpdateEventListener;
	uses org.hibernate.event.spi.PreCollectionRemoveEventListener;
	uses org.hibernate.event.spi.PreDeleteEventListener;
	uses org.hibernate.event.spi.PreCollectionUpdateEventListener;
	uses org.hibernate.event.spi.PreInsertEventListener;
	uses org.hibernate.event.spi.PreLoadEventListener;
	uses org.hibernate.event.spi.PreUpdateEventListener;
	uses org.hibernate.event.spi.RefreshEventListener;
	uses org.hibernate.event.spi.ReplicateEventListener;
	uses org.hibernate.event.spi.ResolveNaturalIdEventListener;
	uses org.hibernate.event.spi.SaveOrUpdateEventListener;

	uses org.hibernate.event.service.spi.DuplicationStrategy;
	uses org.hibernate.event.service.spi.EventListenerGroup;
	uses org.hibernate.event.service.spi.EventListenerRegistry;
	uses org.hibernate.event.service.spi.JpaBootstrapSensitive;
	uses org.hibernate.exception.spi.Configurable;
	uses org.hibernate.exception.spi.ConversionContext;
	uses org.hibernate.exception.spi.SQLExceptionConversionDelegate;
	uses org.hibernate.exception.spi.SQLExceptionConverter;
	uses org.hibernate.exception.spi.ViolatedConstraintNameExtracter;
	uses org.hibernate.graph.spi.AttributeNodeImplementor;
	uses org.hibernate.graph.spi.EntityGraphImplementor;
	uses org.hibernate.graph.spi.GraphNodeImplementor;
	uses org.hibernate.hql.spi.FilterTranslator;
	uses org.hibernate.hql.spi.NamedParameterInformation;
	uses org.hibernate.hql.spi.ParameterInformation;
	uses org.hibernate.hql.spi.ParameterTranslations;
	uses org.hibernate.hql.spi.PositionalParameterInformation;
	uses org.hibernate.hql.spi.QueryTranslator;
	uses org.hibernate.hql.spi.QueryTranslatorFactory;
	uses org.hibernate.hql.spi.id.IdTableInfo;
	uses org.hibernate.hql.spi.id.IdTableSupport;
	uses org.hibernate.hql.spi.id.MultiTableBulkIdStrategy;
	uses org.hibernate.id.factory.spi.MutableIdentifierGeneratorFactory;
	uses org.hibernate.integrator.spi.Integrator;
	uses org.hibernate.integrator.spi.IntegratorService;
	uses org.hibernate.integrator.spi.ServiceContributingIntegrator;
	uses org.hibernate.jmx.spi.JmxService;
	uses org.hibernate.jpa.spi.IdentifierGeneratorStrategyProvider;
	uses org.hibernate.jpa.spi.JpaCompliance;
	uses org.hibernate.jpa.spi.MutableJpaCompliance;
	uses org.hibernate.jpa.spi.NullTypeBindableParameterRegistration;
	uses org.hibernate.jpa.spi.ParameterBind;
	uses org.hibernate.jpa.spi.ParameterRegistration;
	uses org.hibernate.jpa.spi.StoredProcedureQueryParameterRegistration;
	uses org.hibernate.jpa.spi.HibernateEntityManagerFactoryAware;
	uses org.hibernate.jpa.spi.HibernateEntityManagerImplementor;
	uses org.hibernate.jpa.event.spi.Callback;
	uses org.hibernate.jpa.event.spi.CallbackBuilder;
	uses org.hibernate.jpa.event.spi.CallbackRegistry;
	uses org.hibernate.jpa.event.spi.CallbackRegistryConsumer;
	uses org.hibernate.jpa.event.spi.jpa.ExtendedBeanManager;
	uses org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
	uses org.hibernate.jpa.boot.spi.IntegratorProvider;
	uses org.hibernate.jpa.boot.spi.PersistenceUnitDescriptor;
	uses org.hibernate.jpa.boot.spi.StrategyRegistrationProviderList;
	uses org.hibernate.jpa.boot.spi.TypeContributorList;

	uses org.hibernate.loader.spi.AfterLoadAction;
	uses org.hibernate.loader.plan.spi.AnyAttributeFetch;
	uses org.hibernate.loader.plan.spi.AttributeFetch;
	uses org.hibernate.loader.plan.spi.BidirectionalEntityReference;
	uses org.hibernate.loader.plan.spi.CollectionAttributeFetch;
	uses org.hibernate.loader.plan.spi.CollectionFetchableElement;
	uses org.hibernate.loader.plan.spi.CollectionFetchableIndex;
	uses org.hibernate.loader.plan.spi.CollectionQuerySpace;
	uses org.hibernate.loader.plan.spi.CollectionReference;
	uses org.hibernate.loader.plan.spi.CollectionReturn;
	uses org.hibernate.loader.plan.spi.CompositeAttributeFetch;
	uses org.hibernate.loader.plan.spi.CompositeFetch;
	uses org.hibernate.loader.plan.spi.CompositeQuerySpace;
	uses org.hibernate.loader.plan.spi.EntityFetch;
	uses org.hibernate.loader.plan.spi.EntityIdentifierDescription;
	uses org.hibernate.loader.plan.spi.EntityQuerySpace;
	uses org.hibernate.loader.plan.spi.EntityReference;
	uses org.hibernate.loader.plan.spi.EntityReturn;
	uses org.hibernate.loader.plan.spi.Fetch;
	uses org.hibernate.loader.plan.spi.FetchSource;
	uses org.hibernate.loader.plan.spi.Join;
	uses org.hibernate.loader.plan.spi.JoinDefinedByMetadata;
	uses org.hibernate.loader.plan.spi.LoadPlan;
	uses org.hibernate.loader.plan.spi.QuerySpace;
	uses org.hibernate.loader.plan.spi.QuerySpaces;
	uses org.hibernate.loader.plan.spi.Return;
	uses org.hibernate.loader.plan.spi.ScalarReturn;

	uses org.hibernate.persister.spi.HydratedCompoundValueHandler;
	uses org.hibernate.persister.spi.PersisterClassResolver;
	uses org.hibernate.persister.spi.PersisterCreationContext;
	uses org.hibernate.persister.spi.PersisterFactory;
	uses org.hibernate.persister.walking.spi.AnyMappingDefinition;
	uses org.hibernate.persister.walking.spi.AssociationAttributeDefinition;
	uses org.hibernate.persister.walking.spi.AssociationVisitationStrategy;
	uses org.hibernate.persister.walking.spi.AttributeDefinition;
	uses org.hibernate.persister.walking.spi.AttributeSource;
	uses org.hibernate.persister.walking.spi.CollectionDefinition;
	uses org.hibernate.persister.walking.spi.CollectionElementDefinition;
	uses org.hibernate.persister.walking.spi.CollectionIndexDefinition;
	uses org.hibernate.persister.walking.spi.CompositeCollectionElementDefinition;
	uses org.hibernate.persister.walking.spi.CompositionDefinition;
	uses org.hibernate.persister.walking.spi.EncapsulatedEntityIdentifierDefinition;
	uses org.hibernate.persister.walking.spi.EntityDefinition;
	uses org.hibernate.persister.walking.spi.EntityIdentifierDefinition;
	uses org.hibernate.persister.walking.spi.NonEncapsulatedEntityIdentifierDefinition;
	uses org.hibernate.procedure.spi.CallableStatementSupport;
	uses org.hibernate.procedure.spi.ParameterRegistrationImplementor;
	uses org.hibernate.procedure.spi.ProcedureCallImplementor;
	uses org.hibernate.property.access.spi.Getter;
	uses org.hibernate.property.access.spi.PropertyAccess;
	uses org.hibernate.property.access.spi.PropertyAccessStrategy;
	uses org.hibernate.property.access.spi.PropertyAccessStrategyResolver;
	uses org.hibernate.property.access.spi.Setter;
	uses org.hibernate.query.spi.CloseableIterator;
	uses org.hibernate.query.spi.NativeQueryImplementor;
	uses org.hibernate.query.spi.QueryImplementor;
	uses org.hibernate.query.spi.QueryParameterBinding;
	uses org.hibernate.query.spi.QueryParameterBindings;
	uses org.hibernate.query.spi.QueryParameterBindingTypeResolver;
	uses org.hibernate.query.spi.QueryParameterListBinding;
	uses org.hibernate.query.spi.QueryProducerImplementor;
	uses org.hibernate.query.spi.ScrollableResultsImplementor;
	uses org.hibernate.query.procedure.spi.ProcedureParameterBindingImplementor;
	uses org.hibernate.query.procedure.spi.ProcedureParameterImplementor;
	uses org.hibernate.resource.jdbc.spi.JdbcObserver;
	uses org.hibernate.resource.jdbc.spi.JdbcSessionContext;
	uses org.hibernate.resource.jdbc.spi.JdbcSessionOwner;
	uses org.hibernate.resource.jdbc.spi.LogicalConnectionImplementor;
	uses org.hibernate.resource.jdbc.spi.PhysicalJdbcTransaction;
	uses org.hibernate.resource.jdbc.spi.StatementInspector;
	uses org.hibernate.resource.transaction.spi.DdlTransactionIsolator;
	uses org.hibernate.resource.transaction.spi.SynchronizationRegistry;
	uses org.hibernate.resource.transaction.spi.SynchronizationRegistryImplementor;
	uses org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;
	uses org.hibernate.resource.transaction.spi.TransactionCoordinatorOwner;
	uses org.hibernate.resource.transaction.backend.jdbc.spi.JdbcResourceTransaction;
	uses org.hibernate.resource.transaction.backend.jdbc.spi.JdbcResourceTransactionAccess;
	uses org.hibernate.resource.beans.spi.BeanInstanceProducer;
	uses org.hibernate.resource.beans.spi.ManagedBean;
	uses org.hibernate.resource.beans.spi.ManagedBeanRegistry;
	uses org.hibernate.result.spi.ResultContext;
	uses org.hibernate.secure.spi.JaccService;
	uses org.hibernate.secure.spi.PermissionCheckEntityInformation;
	uses org.hibernate.service.spi.Configurable;
	uses org.hibernate.service.spi.Manageable;
	uses org.hibernate.service.spi.OptionallyManageable;
	uses org.hibernate.service.spi.ServiceContributor;
	uses org.hibernate.service.spi.ServiceInitiator;
	uses org.hibernate.service.spi.ServiceRegistryAwareService;
	uses org.hibernate.service.spi.ServiceRegistryImplementor;
	uses org.hibernate.service.spi.SessionFactoryServiceContributor;
	uses org.hibernate.service.spi.SessionFactoryServiceInitiator;
	uses org.hibernate.service.spi.SessionFactoryServiceInitiatorContext;
	uses org.hibernate.service.spi.SessionFactoryServiceRegistry;
	uses org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;
	uses org.hibernate.service.spi.SessionFactoryServiceRegistryFactory;
	uses org.hibernate.service.spi.Startable;
	uses org.hibernate.service.spi.Stoppable;
	uses org.hibernate.service.spi.Wrapped;
	uses org.hibernate.stat.spi.StatisticsFactory;
	uses org.hibernate.stat.spi.StatisticsImplementor;
	uses org.hibernate.tool.schema.spi.DelayedDropAction;
	uses org.hibernate.tool.schema.spi.DelayedDropRegistry;
	uses org.hibernate.tool.schema.spi.ExceptionHandler;
	uses org.hibernate.tool.schema.spi.ExecutionOptions;
	uses org.hibernate.tool.schema.spi.Exporter;
	uses org.hibernate.tool.schema.spi.JpaTargetAndSourceDescriptor;
	uses org.hibernate.tool.schema.spi.SchemaCreator;
	uses org.hibernate.tool.schema.spi.SchemaDropper;
	uses org.hibernate.tool.schema.spi.SchemaFilter;
	uses org.hibernate.tool.schema.spi.SchemaFilterProvider;
	uses org.hibernate.tool.schema.spi.SchemaManagementTool;
	uses org.hibernate.tool.schema.spi.SchemaMigrator;
	uses org.hibernate.tool.schema.spi.SchemaValidator;
	uses org.hibernate.tool.schema.spi.ScriptSourceInput;
	uses org.hibernate.tool.schema.spi.ScriptTargetOutput;
	uses org.hibernate.tool.schema.spi.SourceDescriptor;
	uses org.hibernate.tool.schema.spi.TargetDescriptor;
	uses org.hibernate.tool.schema.extract.spi.ColumnInformation;
	uses org.hibernate.tool.schema.extract.spi.DatabaseInformation;
	uses org.hibernate.tool.schema.extract.spi.ExtractionContext;
	uses org.hibernate.tool.schema.extract.spi.ForeignKeyInformation;
	uses org.hibernate.tool.schema.extract.spi.IndexInformation;
	uses org.hibernate.tool.schema.extract.spi.InformationExtractor;
	uses org.hibernate.tool.schema.extract.spi.PrimaryKeyInformation;
	uses org.hibernate.tool.schema.extract.spi.SequenceInformation;
	uses org.hibernate.tool.schema.extract.spi.SequenceInformationExtractor;
	uses org.hibernate.tool.schema.extract.spi.TableInformation;
	uses org.hibernate.type.spi.TypeConfigurationAware;
	uses org.hibernate.type.descriptor.spi.JdbcRecommendedSqlTypeMappingContext;
	uses org.hibernate.type.descriptor.sql.spi.SqlTypeDescriptorRegistry;
	uses org.hibernate.type.descriptor.java.spi.JavaTypeDescriptorRegistry;
	uses org.hibernate.type.descriptor.java.spi.RegistryHelper;


	provides javax.persistence.spi.PersistenceProvider with org.hibernate.jpa.HibernatePersistenceProvider;

	opens org.hibernate.cache.spi.entry;
	opens org.hibernate.query.criteria.internal.path;
	exports org.hibernate.cache.internal;
	exports org.hibernate.internal.util;
}
