package com.example.absenceservice.entities;

import com.example.absenceservice.model.Course;
import com.example.absenceservice.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private boolean excused;
    private Long student_id;
    private Long course_id;
   //  @ManyToOne
   // @JoinColumn(name = "student_id")
    @Transient
    private Student student;
 //   @ManyToOne
  //  @JoinColumn(name = "course_id")
    @Transient
    private Course course;
}
