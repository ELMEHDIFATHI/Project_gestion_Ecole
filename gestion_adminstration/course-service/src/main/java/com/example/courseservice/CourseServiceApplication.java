package com.example.courseservice;

import com.example.courseservice.Entity.Course;
import com.example.courseservice.Repositories.CourseRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RestControllerConfiguration;

import java.util.Date;

@SpringBootApplication
public class CourseServiceApplication implements CommandLineRunner {
    @Autowired
    CourseRepos courseRepos;

    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Course.class);
        courseRepos.save(new Course(null,new Date(),new Date() ));
        courseRepos.save(new Course(null,new Date() , new Date() ));
        courseRepos.save(new Course(null,new Date() , new Date()));
    }
}
