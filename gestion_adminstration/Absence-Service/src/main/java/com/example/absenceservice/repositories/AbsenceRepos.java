package com.example.absenceservice.repositories;

import com.example.absenceservice.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AbsenceRepos extends JpaRepository<Absence,Long> {
   // public Absence getAbsenceById(Long id);
}
