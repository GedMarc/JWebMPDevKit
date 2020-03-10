module com.hazelcast.all {
	requires java.logging;
	requires transitive cache.api;
	requires java.transaction.xa;
	requires static java.management;

	requires transitive java.xml;
	requires static org.hibernate.orm.core;

	uses com.hazelcast.client.ClientExtension;

	provides com.hazelcast.client.impl.ClientExtension with com.hazelcast.client.impl.clientside.DefaultClientExtension;

	uses com.hazelcast.com.fasterxml.jackson.core.JsonFactory;

	provides com.hazelcast.com.fasterxml.jackson.core.JsonFactory with com.hazelcast.com.fasterxml.jackson.core.JsonFactory;

	uses com.hazelcast.internal.serialization.DataSerializerHook;

	provides com.hazelcast.internal.serialization.DataSerializerHook with
            com.hazelcast.internal.cluster.impl.ClusterDataSerializerHook,
        com.hazelcast.spi.impl.SpiDataSerializerHook,
        com.hazelcast.internal.partition.impl.PartitionDataSerializerHook,
        com.hazelcast.map.impl.MapDataSerializerHook,
        com.hazelcast.collection.impl.queue.QueueDataSerializerHook,
        com.hazelcast.multimap.impl.MultiMapDataSerializerHook,
        com.hazelcast.collection.impl.collection.CollectionDataSerializerHook,
        com.hazelcast.topic.impl.TopicDataSerializerHook,
        com.hazelcast.executor.impl.ExecutorDataSerializerHook,
        com.hazelcast.durableexecutor.impl.DurableExecutorDataSerializerHook,
        com.hazelcast.internal.locksupport.LockDataSerializerHook,
        com.hazelcast.internal.longregister.LongRegisterDataSerializerHook,
        com.hazelcast.transaction.impl.TransactionDataSerializerHook,
        com.hazelcast.replicatedmap.impl.operation.ReplicatedMapDataSerializerHook,
        com.hazelcast.cache.impl.CacheDataSerializerHook,
        com.hazelcast.ringbuffer.impl.RingbufferDataSerializerHook,
        com.hazelcast.wan.impl.WanDataSerializerHook,
        com.hazelcast.query.impl.predicates.PredicateDataSerializerHook,
        com.hazelcast.cardinality.impl.CardinalityEstimatorDataSerializerHook,
        com.hazelcast.client.impl.ClientDataSerializerHook,
        com.hazelcast.internal.management.ManagementDataSerializerHook,
        com.hazelcast.internal.ascii.TextProtocolsDataSerializerHook,
        com.hazelcast.scheduledexecutor.impl.ScheduledExecutorDataSerializerHook,
        com.hazelcast.internal.usercodedeployment.impl.UserCodeDeploymentSerializerHook,
        com.hazelcast.aggregation.impl.AggregatorDataSerializerHook,
        com.hazelcast.projection.impl.ProjectionDataSerializerHook,
        com.hazelcast.internal.config.ConfigDataSerializerHook,
        com.hazelcast.internal.journal.EventJournalDataSerializerHook,
        com.hazelcast.flakeidgen.impl.FlakeIdGeneratorDataSerializerHook,
        com.hazelcast.spi.impl.merge.SplitBrainDataSerializerHook,
        com.hazelcast.internal.crdt.CRDTDataSerializerHook,
        com.hazelcast.cp.internal.raft.impl.RaftDataSerializerHook,
        com.hazelcast.cp.internal.RaftServiceDataSerializerHook,
        com.hazelcast.cp.internal.session.RaftSessionServiceDataSerializerHook,
        com.hazelcast.cp.internal.datastructures.atomiclong.AtomicLongDataSerializerHook,
        com.hazelcast.cp.internal.datastructures.atomicref.AtomicRefDataSerializerHook,
        com.hazelcast.cp.internal.datastructures.lock.LockDataSerializerHook,
        com.hazelcast.cp.internal.datastructures.semaphore.SemaphoreDataSerializerHook,
        com.hazelcast.cp.internal.datastructures.RaftDataServiceDataSerializerHook,
        com.hazelcast.cp.internal.datastructures.countdownlatch.CountDownLatchDataSerializerHook,
        com.hazelcast.internal.metrics.managementcenter.MetricsDataSerializerHook
			;

	uses com.hazelcast.instance.impl.NodeExtension;
	provides com.hazelcast.instance.impl.NodeExtension with com.hazelcast.instance.impl.DefaultNodeExtension;

	uses com.hazelcast.internal.serialization.PortableHook;

	uses com.hazelcast.nio.serialization.SerializerHook;
	provides com.hazelcast.nio.serialization.SerializerHook with com.hazelcast.hibernate.serialization.Hibernate5CacheEntrySerializerHook
            ;

	uses com.hazelcast.spi.discovery.DiscoveryStrategyFactory;
	provides com.hazelcast.spi.discovery.DiscoveryStrategyFactory with com.hazelcast.spi.discovery.multicast.MulticastDiscoveryStrategyFactory
			;

	uses com.hazelcast.spi.impl.servicemanager.ServiceDescriptorProvider;
	provides com.hazelcast.spi.impl.servicemanager.ServiceDescriptorProvider with com.hazelcast.cp.internal.RaftServiceDescriptorProvider,
com.hazelcast.cp.internal.datastructures.RaftDataServiceDescriptorProvider,
        com.hazelcast.internal.longregister.LongRegisterServiceDescriptorProvider;

	provides javax.cache.spi.CachingProvider with com.hazelcast.cache.HazelcastCachingProvider;



	exports com.hazelcast.client.config;
	exports com.hazelcast.client.cache.impl;

	exports com.hazelcast.client;

	exports com.hazelcast.config;
	exports com.hazelcast.config.matcher;
	exports com.hazelcast.config.properties;
	exports com.hazelcast.console;
	exports com.hazelcast.core;
	exports com.hazelcast.topic;
	exports com.hazelcast.core.server;

	exports com.hazelcast.instance;


}
