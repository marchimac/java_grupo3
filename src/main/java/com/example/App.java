package com.example;

import com.example.entities.Company;
import com.example.repositories.CompanyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);
		var companyRepo = context.getBean(CompanyRepository.class);

		companyRepo.saveAll(List.of(
				new Company(null, "Company1", "Slogan1", "url1", "linkedIn1", "Twitter1", "11111111A"),
				new Company(null, "Company2", "Slogan2", "url2", "linkedIn2", "Twitter2", "22222222B"),
				new Company(null, "Company3", "Slogan3", "url3", "linkedIn3", "Twitter3", "33333333C"),
				new Company(null, "Company4", "Slogan4", "url4", "linkedIn4", "Twitter4", "44444444D")
		));
	}

}
