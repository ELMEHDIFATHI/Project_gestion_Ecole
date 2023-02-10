package com.example.kafka_absence.Controller;

import com.example.absenceservice.entities.Absence;
import com.example.kafka_absence.KAFKA.AbsenceProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class AbsenceController {
    private AbsenceProducer absenceProducer;

    public AbsenceController(AbsenceProducer absenceProducer) {
        this.absenceProducer = absenceProducer;
    }

    @GetMapping ("/absenceskafka")
    public String addabsence()
    {

        Absence absence =  new Absence(null,  new Date(),true, 1L,1L,null,null);

        absenceProducer.sendMessage(absence);
        return  "Absence placed successfully";
    }
}
