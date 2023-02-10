package com.example.absenceservice.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Course {
    private Long id;
    private Date date_debut;
    private Date date_fin;
}
