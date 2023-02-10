package com.example.studentservice;

import com.example.studentservice.entity.Student;
import com.example.studentservice.repositories.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class StudentServiceApplication implements CommandLineRunner {
    @Autowired
    private StudentRepos studentRepos;

    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Student.class);
        studentRepos.save(new Student(null,"Yassine", "ARCHID"));
        studentRepos.save(new Student(null,"El mehdi", "FATHI"));
        studentRepos.save(new Student(null,"Anas", "toto"));




    }
}
