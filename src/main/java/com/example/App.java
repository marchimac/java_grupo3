package com.example;

import com.example.entities.Company;
import com.example.entities.Project;
import com.example.repositories.CompanyRepository;
import com.example.repositories.ProjectRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		var companyRepo = context.getBean(CompanyRepository.class);
		var projectRepo = context.getBean(ProjectRepository.class);

		companyRepo.saveAll(List.of(
				new Company(null, "Company1", "Slogan1", "url1", "linkedIn1", "Twitter1", "11111111A"),
				new Company(null, "Company2", "Slogan2", "url2", "linkedIn2", "Twitter2", "22222222B"),
				new Company(null, "Company3", "Slogan3", "url3", "linkedIn3", "Twitter3", "33333333C"),
				new Company(null, "Company4", "Slogan4", "url4", "linkedIn4", "Twitter4", "44444444D")
		));

		projectRepo.saveAll(List.of(
				new Project(null, "Project1", "webapp", LocalDate.of(2023, 11, 2), LocalDate.of(2023, 12, 2), 2000.0),
				new Project(null, "Project2", "webapp2", LocalDate.of(2022, 10, 2), LocalDate.of(2022, 12, 2), 4000.0)));


	}

}
