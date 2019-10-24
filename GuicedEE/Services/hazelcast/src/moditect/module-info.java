module com.hazelcast.all {
	requires java.logging;
	requires cache.api;
	requires java.transaction.xa;
	requires static java.management;

	requires java.xml;
	requires static org.hibernate.orm.core;

	uses com.hazelcast.client.ClientExtension;
	provides com.hazelcast.client.ClientExtension with com.hazelcast.client.impl.clientside.DefaultClientExtension;

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
			com.hazelcast.concurrent.lock.LockDataSerializerHook,
			com.hazelcast.concurrent.semaphore.SemaphoreDataSerializerHook,
			com.hazelcast.concurrent.atomiclong.AtomicLongDataSerializerHook,
			com.hazelcast.transaction.impl.TransactionDataSerializerHook,
			com.hazelcast.concurrent.countdownlatch.CountDownLatchDataSerializerHook,
			com.hazelcast.concurrent.atomicreference.AtomicReferenceDataSerializerHook,
			com.hazelcast.mapreduce.impl.MapReduceDataSerializerHook,
			com.hazelcast.replicatedmap.impl.operation.ReplicatedMapDataSerializerHook,
			com.hazelcast.mapreduce.aggregation.impl.AggregationsDataSerializerHook,
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
			com.hazelcast.config.ConfigDataSerializerHook,
			com.hazelcast.internal.journal.EventJournalDataSerializerHook,
			com.hazelcast.flakeidgen.impl.FlakeIdGeneratorDataSerializerHook,
			com.hazelcast.spi.impl.merge.SplitBrainDataSerializerHook,
			com.hazelcast.crdt.CRDTDataSerializerHook,
			com.hazelcast.cp.internal.raft.impl.RaftDataSerializerHook,
			com.hazelcast.cp.internal.RaftServiceDataSerializerHook,
			com.hazelcast.cp.internal.session.RaftSessionServiceDataSerializerHook,
			com.hazelcast.cp.internal.datastructures.atomiclong.RaftAtomicLongDataSerializerHook,
			com.hazelcast.cp.internal.datastructures.atomicref.RaftAtomicReferenceDataSerializerHook,
			com.hazelcast.cp.internal.datastructures.lock.RaftLockDataSerializerHook,
			com.hazelcast.cp.internal.datastructures.semaphore.RaftSemaphoreDataSerializerHook,
			com.hazelcast.cp.internal.datastructures.RaftDataServiceDataSerializerHook,
			com.hazelcast.cp.internal.datastructures.countdownlatch.RaftCountDownLatchDataSerializerHook,
			com.hazelcast.hibernate.serialization.HibernateDataSerializerHook
			//com.hazelcast.web.WebDataSerializerHook
			;

	uses com.hazelcast.instance.NodeExtension;
	uses com.hazelcast.internal.serialization.PortableHook;
	provides com.hazelcast.internal.serialization.PortableHook with com.hazelcast.spi.impl.SpiPortableHook,
			com.hazelcast.internal.partition.impl.PartitionPortableHook,
			com.hazelcast.mapreduce.impl.MapReducePortableHook,
			com.hazelcast.replicatedmap.impl.client.ReplicatedMapPortableHook,
			com.hazelcast.ringbuffer.impl.client.RingbufferPortableHook,
			com.hazelcast.map.impl.client.MapPortableHook;

	uses com.hazelcast.nio.serialization.SerializerHook;
	provides com.hazelcast.nio.serialization.SerializerHook with com.hazelcast.hibernate.serialization.Hibernate5CacheEntrySerializerHook;

	uses com.hazelcast.spi.discovery.DiscoveryStrategyFactory;
	provides com.hazelcast.spi.discovery.DiscoveryStrategyFactory with com.hazelcast.spi.discovery.multicast.MulticastDiscoveryStrategyFactory
			//   com.hazelcast.aws.AwsDiscoveryStrategyFactory,
			// com.hazelcast.gcp.GcpDiscoveryStrategyFactory
			//com.hazelcast.kubernetes.HazelcastKubernetesDiscoveryStrategyFactory
			;



	uses com.hazelcast.spi.impl.servicemanager.ServiceDescriptorProvider;
	provides com.hazelcast.spi.impl.servicemanager.ServiceDescriptorProvider with com.hazelcast.cp.internal.RaftServiceDescriptorProvider,
			com.hazelcast.cp.internal.datastructures.RaftDataServiceDescriptorProvider;

	provides javax.cache.spi.CachingProvider with com.hazelcast.cache.HazelcastCachingProvider;


	exports com.hazelcast.client.config;
	exports com.hazelcast.client.cache.impl;

	//exports com.hazelcast;
	/*exports com.hazelcast.aggregation;
	exports com.hazelcast.aggregation.impl;*/
	//exports com.hazelcast.buildutils;
	/*exports com.hazelcast.cache;
	exports com.hazelcast.cache.impl;
	exports com.hazelcast.cache.impl.event;*/
//	exports com.hazelcast.cache.impl.maxsize;
	//exports com.hazelcast.cache.impl.maxsize.impl;
	//exports com.hazelcast.cache.impl.merge;
	/*exports com.hazelcast.cache.impl.merge.entry;
	exports com.hazelcast.cache.impl.merge.policy;
	exports com.hazelcast.cache.impl.operation;
	exports com.hazelcast.cache.impl.record;
	exports com.hazelcast.cache.merge;
	exports com.hazelcast.cardinality;
	exports com.hazelcast.cardinality.impl;
	exports com.hazelcast.cardinality.impl.hyperloglog;
	exports com.hazelcast.cardinality.impl.hyperloglog.impl;
	exports com.hazelcast.cardinality.impl.operations;*/
	exports com.hazelcast.client;
	/*
	exports com.hazelcast.client.cache.impl.nearcache.invalidation;

	exports com.hazelcast.client.connection;
	exports com.hazelcast.client.connection.nio;
	exports com.hazelcast.client.console;
	exports com.hazelcast.client.impl;
	exports com.hazelcast.client.impl.client;
	exports com.hazelcast.client.impl.operations;
	exports com.hazelcast.client.impl.protocol;
	exports com.hazelcast.client.impl.protocol.exception;
	exports com.hazelcast.client.impl.protocol.task;
	exports com.hazelcast.client.impl.protocol.task.atomiclong;
	exports com.hazelcast.client.impl.protocol.task.atomicreference;
	exports com.hazelcast.client.impl.protocol.task.cache;
	exports com.hazelcast.client.impl.protocol.task.cardinality;
	exports com.hazelcast.client.impl.protocol.task.condition;
	exports com.hazelcast.client.impl.protocol.task.countdownlatch;
	exports com.hazelcast.client.impl.protocol.task.executorservice;
	exports com.hazelcast.client.impl.protocol.task.executorservice.durable;
	exports com.hazelcast.client.impl.protocol.task.list;
	exports com.hazelcast.client.impl.protocol.task.lock;
	exports com.hazelcast.client.impl.protocol.task.map;
	exports com.hazelcast.client.impl.protocol.task.mapreduce;
	exports com.hazelcast.client.impl.protocol.task.multimap;
	exports com.hazelcast.client.impl.protocol.task.queue;
	exports com.hazelcast.client.impl.protocol.task.replicatedmap;
	exports com.hazelcast.client.impl.protocol.task.ringbuffer;
	exports com.hazelcast.client.impl.protocol.task.scheduledexecutor;
	exports com.hazelcast.client.impl.protocol.task.semaphore;
	exports com.hazelcast.client.impl.protocol.task.set;
	exports com.hazelcast.client.impl.protocol.task.topic;
	exports com.hazelcast.client.impl.protocol.task.transaction;
	exports com.hazelcast.client.impl.protocol.task.transactionallist;
	exports com.hazelcast.client.impl.protocol.task.transactionalmap;
	exports com.hazelcast.client.impl.protocol.task.transactionalmultimap;
	exports com.hazelcast.client.impl.protocol.task.transactionalqueue;
	exports com.hazelcast.client.impl.protocol.task.transactionalset;
	exports com.hazelcast.client.impl.protocol.util;
	exports com.hazelcast.client.impl.querycache;
	exports com.hazelcast.client.impl.querycache.subscriber;
	exports com.hazelcast.client.map.impl;
	exports com.hazelcast.client.map.impl.nearcache.invalidation;
	exports com.hazelcast.client.proxy;
	exports com.hazelcast.client.proxy.txn;
	exports com.hazelcast.client.proxy.txn.xa;
	exports com.hazelcast.client.spi;
	exports com.hazelcast.client.spi.impl;
	exports com.hazelcast.client.spi.impl.discovery;
	exports com.hazelcast.client.spi.impl.listener;
	exports com.hazelcast.client.spi.properties;
	exports com.hazelcast.client.util;*/
	/*exports com.hazelcast.cluster;
	exports com.hazelcast.cluster.impl;
	exports com.hazelcast.cluster.memberselector;*/
	/*exports com.hazelcast.collection.impl;
	exports com.hazelcast.collection.impl.collection;
	exports com.hazelcast.collection.impl.collection.operations;
	exports com.hazelcast.collection.impl.common;
	exports com.hazelcast.collection.impl.list;
	exports com.hazelcast.collection.impl.list.operations;
	exports com.hazelcast.collection.impl.queue;
	exports com.hazelcast.collection.impl.queue.operations;
	exports com.hazelcast.collection.impl.set;
	exports com.hazelcast.collection.impl.set.operations;
	exports com.hazelcast.collection.impl.txncollection;
	exports com.hazelcast.collection.impl.txncollection.operations;
	exports com.hazelcast.collection.impl.txnlist;
	exports com.hazelcast.collection.impl.txnqueue;
	exports com.hazelcast.collection.impl.txnqueue.operations;
	exports com.hazelcast.collection.impl.txnset;
	exports com.hazelcast.concurrent.atomiclong;

	exports com.hazelcast.concurrent.atomiclong.operations;
	exports com.hazelcast.concurrent.atomicreference;

	exports com.hazelcast.concurrent.atomicreference.operations;
	exports com.hazelcast.concurrent.countdownlatch;

	exports com.hazelcast.concurrent.countdownlatch.operations;
	exports com.hazelcast.concurrent.idgen;

	exports com.hazelcast.concurrent.lock;

	exports com.hazelcast.concurrent.lock.operations;
	exports com.hazelcast.concurrent.semaphore;

	exports com.hazelcast.concurrent.semaphore.operations;*/
	exports com.hazelcast.config;
	exports com.hazelcast.config.matcher;
	exports com.hazelcast.config.properties;
	exports com.hazelcast.console;
	exports com.hazelcast.core;
	exports com.hazelcast.core.server;
	//exports com.hazelcast.durableexecutor;

	/*exports com.hazelcast.durableexecutor.impl;
	exports com.hazelcast.durableexecutor.impl.operations;
	exports com.hazelcast.executor.impl;
	exports com.hazelcast.executor.impl.operations;
	exports com.hazelcast.hotrestart;*/
	exports com.hazelcast.instance;
	/*exports com.hazelcast.internal;
	exports com.hazelcast.internal.adapter;
	exports com.hazelcast.internal.ascii;
	exports com.hazelcast.internal.ascii.memcache;
	exports com.hazelcast.internal.ascii.rest;
	exports com.hazelcast.internal.cluster;
	exports com.hazelcast.internal.cluster.impl;
	exports com.hazelcast.internal.cluster.impl.operations;
	exports com.hazelcast.internal.config;
	exports com.hazelcast.internal.diagnostics;
	exports com.hazelcast.internal.eviction;*/
	//exports com.hazelcast.internal.eviction.impl;
	/*exports com.hazelcast.internal.eviction.impl.comparator;
	exports com.hazelcast.internal.eviction.impl.evaluator;*/
	//exports com.hazelcast.internal.eviction.impl.strategy;
	/*exports com.hazelcast.internal.eviction.impl.strategy.sampling;
	exports com.hazelcast.internal.jmx;
	exports com.hazelcast.internal.jmx.suppliers;
	exports com.hazelcast.internal.management;
	exports com.hazelcast.internal.management.dto;
	exports com.hazelcast.internal.management.operation;
	exports com.hazelcast.internal.management.request;
	exports com.hazelcast.internal.memory;
	exports com.hazelcast.internal.memory.impl;
	exports com.hazelcast.internal.metrics;
	exports com.hazelcast.internal.metrics.impl;
	exports com.hazelcast.internal.metrics.metricsets;
	exports com.hazelcast.internal.metrics.renderers;
	exports com.hazelcast.internal.nearcache;
	exports com.hazelcast.internal.nearcache.impl;
	exports com.hazelcast.internal.nearcache.impl.invalidation;
	exports com.hazelcast.internal.nearcache.impl.maxsize;
	exports com.hazelcast.internal.nearcache.impl.preloader;
	exports com.hazelcast.internal.nearcache.impl.record;
	exports com.hazelcast.internal.nearcache.impl.store;
	exports com.hazelcast.internal.networking;*/
	//exports com.hazelcast.internal.networking.nonblocking;
	//exports com.hazelcast.internal.networking.nonblocking.iobalancer;
	//exports com.hazelcast.internal.networking.spinning;
	/*exports com.hazelcast.internal.partition;
	exports com.hazelcast.internal.partition.impl;
	exports com.hazelcast.internal.partition.operation;
	exports com.hazelcast.internal.serialization;
	exports com.hazelcast.internal.serialization.impl;
	exports com.hazelcast.internal.serialization.impl.bufferpool;
	exports com.hazelcast.internal.usercodedeployment;
	exports com.hazelcast.internal.usercodedeployment.impl;
	exports com.hazelcast.internal.usercodedeployment.impl.filter;
	exports com.hazelcast.internal.usercodedeployment.impl.operation;
	exports com.hazelcast.internal.util;
	exports com.hazelcast.internal.util.collection;
	exports com.hazelcast.internal.util.concurrent;
	exports com.hazelcast.internal.util.counters;
	exports com.hazelcast.internal.util.filter;
	exports com.hazelcast.internal.util.hashslot;
	exports com.hazelcast.internal.util.hashslot.impl;
	exports com.hazelcast.internal.util.sort;
	exports com.hazelcast.logging;*/
	/*exports com.hazelcast.map;
	exports com.hazelcast.map.eviction;
	exports com.hazelcast.map.impl;
	exports com.hazelcast.map.impl.client;
	exports com.hazelcast.map.impl.event;
	exports com.hazelcast.map.impl.eviction;
	exports com.hazelcast.map.impl.iterator;
	exports com.hazelcast.map.impl.mapstore;
	exports com.hazelcast.map.impl.mapstore.writebehind;
	exports com.hazelcast.map.impl.mapstore.writebehind.entry;
	exports com.hazelcast.map.impl.mapstore.writethrough;
	exports com.hazelcast.map.impl.nearcache;
	exports com.hazelcast.map.impl.nearcache.invalidation;
	exports com.hazelcast.map.impl.operation;
	exports com.hazelcast.map.impl.proxy;
	exports com.hazelcast.map.impl.query;
	exports com.hazelcast.map.impl.querycache;
	exports com.hazelcast.map.impl.querycache.accumulator;
	exports com.hazelcast.map.impl.querycache.event;
	exports com.hazelcast.map.impl.querycache.event.sequence;
	exports com.hazelcast.map.impl.querycache.publisher;
	exports com.hazelcast.map.impl.querycache.subscriber;
	exports com.hazelcast.map.impl.querycache.subscriber.operation;
	exports com.hazelcast.map.impl.querycache.subscriber.record;
	exports com.hazelcast.map.impl.querycache.utils;
	exports com.hazelcast.map.impl.record;
	exports com.hazelcast.map.impl.recordstore;
	exports com.hazelcast.map.impl.tx;
	exports com.hazelcast.map.impl.wan;
	exports com.hazelcast.map.listener;
	exports com.hazelcast.map.merge;
	exports com.hazelcast.mapreduce;
	exports com.hazelcast.mapreduce.aggregation;
	exports com.hazelcast.mapreduce.aggregation.impl;*/


}
