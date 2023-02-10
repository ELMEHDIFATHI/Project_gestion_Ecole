package com.example.absenceservice;

import com.example.absenceservice.Services.CourseRestClient;
import com.example.absenceservice.Services.StudentRestClient;
import com.example.absenceservice.entities.Absence;
import com.example.absenceservice.model.Course;
import com.example.absenceservice.model.Student;
import com.example.absenceservice.repositories.AbsenceRepos;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
@EnableFeignClients
public class AbsenceServiceApplication implements CommandLineRunner {

    private  StudentRestClient studentRestClient;
    private  CourseRestClient courseRestClient;
    private  AbsenceRepos absenceRepository;



    public static void main(String[] args) {
        SpringApplication.run(AbsenceServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Long student_id=1L;
        Long course_id=1L;
        Course course = courseRestClient.getCourseById(course_id);
        if (course == null) {
            throw new RuntimeException("course not found");
        }
        Student student = studentRestClient.getStudentById(student_id);
        if (student == null) {
            throw new RuntimeException("student not found");
        }

        Absence absence=new Absence();
        absence.setDate(new Date());
        absence.setExcused(true);
        absence.setStudent_id(student_id);
        absence.setCourse_id(course_id);
        absenceRepository.save(absence);

    }




}
