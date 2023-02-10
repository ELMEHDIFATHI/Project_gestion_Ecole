package com.example.kafka_absence.KAFKA;

import com.example.absenceservice.entities.Absence;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;



import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class AbsenceProducer {
    private  static final Logger LOGGER = LoggerFactory.getLogger(AbsenceProducer.class);
    private NewTopic topic;

    private KafkaTemplate<Long, Absence> kafkaTemplate;

    public AbsenceProducer(NewTopic topic, KafkaTemplate<Long, Absence> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public  void sendMessage(Absence absence)
    {
        LOGGER.info(String.format("Absence => %s",absence.toString()));
        org.springframework.messaging.Message<Absence> message = MessageBuilder
                .withPayload(absence)
                .setHeader(KafkaHeaders.TOPIC,topic.name()).build();

        kafkaTemplate.send(message);
    }

}
