package com.example.courseservice.Repositories;

import com.example.courseservice.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CourseRepos extends JpaRepository<Course,Long> {
}
