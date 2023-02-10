package com.example.kafka_absence;

import com.example.absenceservice.entities.Absence;
import com.example.kafka_absence.KAFKA.AbsenceProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class KafkaAbsenceApplication {
    private AbsenceProducer absenceProducer;

    public KafkaAbsenceApplication(AbsenceProducer absenceProducer) {
        this.absenceProducer = absenceProducer;
    }

    long leftLimit = 1L;
    long rightLimit = 1L;
    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    public static void main(String[] args) {
        SpringApplication.run(KafkaAbsenceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 0; i < 5; i++) {
                Absence absence =  new Absence(null,  new Date(),true, 1L,1L,null,null);
                System.out.println(absence);
                absenceProducer.sendMessage(absence);
            }








        };
    }

}
