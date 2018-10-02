package io.blueharvest.labs.axon.command;

import io.axoniq.axondb.client.AxonDBConfiguration;
import io.axoniq.axondb.client.axon.AxonDBEventStore;
import org.axonframework.common.caching.Cache;
import org.axonframework.common.caching.WeakReferenceCache;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.annotation.ParameterResolverFactory;
import org.axonframework.serialization.Serializer;
import org.axonframework.spring.eventsourcing.SpringAggregateSnapshotter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class AggregateConfig {
//    @Bean
//    public EventStorageEngine eventStorageEngine(MongoClient client) {
//        return new MongoEventStorageEngine(new DefaultMongoTemplate(client));
//    }

    /*@Bean
    public Cache cache(){
        return new WeakReferenceCache();
    }

    @Bean(name = "eventBus")
    public EventStore eventStore(AxonDBConfiguration axonDBConfiguration, Serializer serializer) {
        return new AxonDBEventStore(axonDBConfiguration, serializer);
    }

    @Bean
    public AxonDBConfiguration axonDBConfiguration() {
        return new AxonDBConfiguration();
    }

    @Bean
    public SpringAggregateSnapshotter snapshotter(ParameterResolverFactory parameterResolverFactory, EventStore eventStore, TransactionManager transactionManager) {
        Executor executor = Executors.newSingleThreadExecutor(); //Or any other executor of course
        return new SpringAggregateSnapshotter(eventStore, parameterResolverFactory, executor, transactionManager);
    }

    @Bean
    public SnapshotTriggerDefinition snapshotTriggerDefinition(Snapshotter snapshotter) throws Exception {
        return new EventCountSnapshotTriggerDefinition(snapshotter, 3);
    }*/
}