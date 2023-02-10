package com.example.kafkastream;

import com.example.absenceservice.entities.Absence;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class KAFkaStreamConsumer {
    public static void main(String[] args) {
        new KAFkaStreamConsumer().start();
    }

    private void start() {
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "strams-Consumer-1");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 1000);
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        StreamsBuilder streamsBuilder= new StreamsBuilder();
        KStream<String,String> kStream=
                streamsBuilder.stream("mehdifathi1", Consumed.with(Serdes.String(), Serdes.String()));
        kStream.flatMapValues(textLine-> Arrays.asList(textLine.split("\\w+")))
                .foreach((k,v)->{
            System.out.println(k+"=>"+v);
        });

        Topology topology = streamsBuilder.build();
        KafkaStreams kafkaStreams =new KafkaStreams(topology,properties);
        kafkaStreams.start();

 }
}

