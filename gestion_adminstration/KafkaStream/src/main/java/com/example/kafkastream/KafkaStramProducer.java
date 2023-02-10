package com.example.kafkastream;

import com.example.absenceservice.entities.Absence;
import com.example.absenceservice.model.Course;
import com.example.absenceservice.model.Student;
import kafka.tools.ConsoleProducer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class KafkaStramProducer {

    public static void main(String[] args) {
        new KafkaStramProducer().start();
    }

    private void start() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "strams-prod-1");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            String message = "absense";
            for (int i = 0; i < 10; i++) {

                Absence absence = new Absence();
                absence.setDate(new Date());
                absence.setExcused(true);
                absence.setStudent_id((long) i);
                absence.setCourse_id((long) i);
                kafkaProducer.send(new ProducerRecord<String, String>("mehdifathi1", null, message), (md, ex) -> {
                    System.out.println("this" + absence.getCourse()+"l etudiant "+absence.getStudent_id()+"excuse"+absence.isExcused() );
                });

            }

        }, 1000, 1000, TimeUnit.MILLISECONDS);

    }
}
