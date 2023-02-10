package com.example.absenceservice.Services;

import com.example.absenceservice.model.Course;
import com.example.absenceservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseRestClient {

    @GetMapping(path = "/courses/{id}")
    public Course getCourseById(@PathVariable Long id);

    @GetMapping(path = "/Courses")
    List<Course> getCourses();

    @PostMapping("/addCourse")
    public Course createCourse(@RequestBody Course course);

    @PutMapping("/updateCourse/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course);

    @DeleteMapping("/deletecourse/{id}")
    public void deleteCourse(@PathVariable Long id);


}
