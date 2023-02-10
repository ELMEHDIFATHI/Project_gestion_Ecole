package com.example.absenceservice.Services;

import com.example.absenceservice.model.Course;
import com.example.absenceservice.model.Professor;
import com.example.absenceservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PROFESSOR-SERVICE")
public interface ProfessorRestClient {
    @GetMapping(path = "/professors/{id}")
    public Course getProfessorById(@PathVariable Long id);

    @GetMapping(path = "/professors")
    List<Professor> getprofessors();

    @PostMapping("/addProfessor")
    public Professor createProfessor(@RequestBody Professor professor);

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor);

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable Long id);
}
