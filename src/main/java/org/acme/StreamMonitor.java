package org.acme;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.cli.annotations.ParsedAsList;
import org.apache.kafka.common.Metric;
import org.apache.kafka.common.metrics.Metrics;
import org.apache.kafka.streams.KafkaStreams;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class StreamMonitor {

    private static final Logger LOG = LoggerFactory.getLogger(StreamMonitor.class);


    @Inject
    MetricRegistry metricRegistry;

    @Inject
    KafkaStreams kafkaStreams;


    void startUp(@Observes StartupEvent ev){
        LOG.info("Initializing metrics exporter");
    }

    @PostConstruct
    void init(){

        LOG.info("My stream as a String: "+kafkaStreams);
        // Sometimes it gives a NPE
        var metrics = kafkaStreams.metrics();

        //for (Metric m : metrics.values()){
            // implement metrics export like following example, but sometimes npe happens
            // https://quarkus.io/blog/kafka-streams-applications-with-quarkus-and-microprofile/
        //}
    }




}
