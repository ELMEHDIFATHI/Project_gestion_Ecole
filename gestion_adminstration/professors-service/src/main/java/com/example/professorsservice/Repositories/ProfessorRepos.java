package com.example.professorsservice.Repositories;

import com.example.professorsservice.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessorRepos extends JpaRepository<Professor,Long> {
}
