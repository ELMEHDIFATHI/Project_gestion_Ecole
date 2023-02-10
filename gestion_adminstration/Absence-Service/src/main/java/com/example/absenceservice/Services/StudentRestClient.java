package com.example.absenceservice.Services;

import com.example.absenceservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "STUDENT-SERVICE")
public interface StudentRestClient {

    @GetMapping(path = "/students/{id}")
    public Student getStudentById(@PathVariable Long id);

    @GetMapping(path = "/students")
    List<Student> getStudents();

    @PostMapping
    public Student createStudent(@RequestBody Student student);

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student);

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id);


}
