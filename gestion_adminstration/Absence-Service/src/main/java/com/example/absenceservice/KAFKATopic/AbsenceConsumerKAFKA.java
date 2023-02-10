package com.example.absenceservice.KAFKATopic;
import com.example.absenceservice.entities.Absence;
import com.example.absenceservice.repositories.AbsenceRepos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AbsenceConsumerKAFKA {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbsenceConsumerKAFKA.class);
    private AbsenceRepos absenceRepo;

    public AbsenceConsumerKAFKA(AbsenceRepos absenceRepo) {
        this.absenceRepo = absenceRepo;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public  void  consume(Absence absence){
        LOGGER.info(String.format("good"+absence.toString()));
        absenceRepo.save(absence);
    }
}
