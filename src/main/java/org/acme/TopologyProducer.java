package org.acme;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class TopologyProducer {

    private static final Logger LOG = LoggerFactory.getLogger(TopologyProducer.class);

    private static final String INPUT_TOPIC = "test-topic";

    @Produces
    public Topology topologyBuilder(){
        StreamsBuilder builder = new StreamsBuilder();
        builder.stream(INPUT_TOPIC
        ).foreach((k,v) -> LOG.info("Key: "+k.toString()));

        return builder.build();
    }

}
