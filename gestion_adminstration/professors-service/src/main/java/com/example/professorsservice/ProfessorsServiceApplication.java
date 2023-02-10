package com.example.professorsservice;

import com.example.professorsservice.Entity.Professor;
import com.example.professorsservice.Repositories.ProfessorRepos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication


public class ProfessorsServiceApplication implements CommandLineRunner {




	@Autowired
	private ProfessorRepos professorRepos;

	@Autowired
	RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ProfessorsServiceApplication.class, args);
	}





	@Override
	public void run(String... args) throws Exception {
/*		Long course_id=1L;
		Course course = courseRestClientt.getCourseById(course_id);
		if (course == null) {
			throw new RuntimeException("course not found");
		}

		Professor professor=new Professor();
		professor.setName("Khadija");
		professor.setPrenom("AHAIDOUS");
		professor.setCourse_id(course_id);
		professorRepos.save(professor);


	 */
		repositoryRestConfiguration.exposeIdsFor(Professor.class);

		professorRepos.save(new Professor(null,"Khadija", "AHAIDOUS"));
		professorRepos.save(new Professor(null,"Mohammed", "YOUSSFI"));
		professorRepos.save(new Professor(null,"Chaimaa", "LAOUT"));


	}
}
