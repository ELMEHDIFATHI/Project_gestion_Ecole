package com.example.absenceservice.web;

import com.example.absenceservice.Services.CourseRestClient;
import com.example.absenceservice.Services.StudentRestClient;
import com.example.absenceservice.entities.Absence;
import com.example.absenceservice.exception.AbsenceNotFoundException;
import com.example.absenceservice.model.Course;
import com.example.absenceservice.model.Student;
import com.example.absenceservice.repositories.AbsenceRepos;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AbsenceController {

    private StudentRestClient studentRestClient;
    private CourseRestClient courseRestClient;
    private AbsenceRepos absenceRepository;

    public AbsenceController(StudentRestClient studentRestClient, CourseRestClient courseRestClient, AbsenceRepos absenceRepository) {
        this.studentRestClient = studentRestClient;
        this.courseRestClient = courseRestClient;
        this.absenceRepository = absenceRepository;
    }


    @GetMapping("/absences/{id}")

    public Absence absence(@PathVariable Long id) {
        Absence absence = absenceRepository.findById(id).get();
        absence.setCourse(courseRestClient.getCourseById(absence.getCourse_id()));
        absence.setStudent(studentRestClient.getStudentById(absence.getStudent_id()));
        return absence;
    }

    @GetMapping("/absences")
      @PreAuthorize("hasAuthority('etudiant')")
    public List<Absence> getAll() {
        System.out.println("liste absence");
        return absenceRepository.findAll();
    }

    @PostMapping("/addAbsence")
    @PreAuthorize("hasAuthority('admin')")
    public Absence addAbsence(@RequestBody Absence absence) {
        return absenceRepository.save(absence);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('professeur')")
    public Absence updateAbsence(@PathVariable Long id, @RequestBody Absence updatedAbsence) {
        Absence absence = absenceRepository.findById(id).orElseThrow(() -> new AbsenceNotFoundException(id));
        absence.setDate(updatedAbsence.getDate());
        absence.setExcused(updatedAbsence.isExcused());
        return absenceRepository.save(absence);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('professeur')")
    public void deleteAbsence(@PathVariable Long id) {
        absenceRepository.deleteById(id);
    }


  /*  public Absence updateAbsence(Long id, Absence absence) {
        Absence existingAbsence = getAbsenceById(id);

        // Vérifier si le cours et l'étudiant existent
        Course course = courseRestClient.getCourseById(absence.getCourse().getId());
        if (course == null) {
            throw new RuntimeException("course not found");
        }
        Student student = studentRestClient.getStudentById(absence.getStudent().getId());
        if (student == null) {
            throw new RuntimeException("student not found");
        }

        // Attacher le cours et l'étudiant à l'absence
        existingAbsence.setCourse(course);
        existingAbsence.setStudent(student);
        existingAbsence.setDate(absence.getDate());

        return absenceRepository.save(existingAbsence);

    }

*/

}

