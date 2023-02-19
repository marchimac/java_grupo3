package com.example;

import com.example.entities.*;
import com.example.repositories.*;
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
		var customerRepo = context.getBean(CustomerRepository.class);
		var employeeRepo = context.getBean(EmployeeRepository.class);
		var addressRepo = context.getBean(AddressRepository.class);

		companyRepo.saveAll(List.of(
				new Company(null, "Company1", "Slogan1", "url1", "linkedIn1", "Twitter1", "11111111A"),
				new Company(null, "Company2", "Slogan2", "url2", "linkedIn2", "Twitter2", "22222222B"),
				new Company(null, "Company3", "Slogan3", "url3", "linkedIn3", "Twitter3", "33333333C"),
				new Company(null, "Company4", "Slogan4", "url4", "linkedIn4", "Twitter4", "44444444D")
		));

		addressRepo.saveAll(List.of(
				new Address(null, "Calle 1", "11111", "City 1", "Country 1"),
				new Address(null, "Calle 2", "22222", "City 2", "Country 2"),
				new Address(null, "Calle 3", "33333", "City 3", "Country 3"),
				new Address(null, "Calle 4", "44444", "City 4", "Country 4")
		));

		projectRepo.saveAll(List.of(
				new Project(null, "Project1", "webapp", LocalDate.of(2023, 11, 2), LocalDate.of(2023, 12, 2), 2000.0),
				new Project(null, "Project2", "webapp2", LocalDate.of(2022, 10, 2), LocalDate.of(2022, 12, 2), 4000.0)));

		// Create and save demo customers:
		customerRepo.saveAll(List.of(
				new Customer(null, "Customer1", "123A", "123456789", "customer1@email.com"),
				new Customer(null, "Customer2", "456B", "987654321", "customer2@email.com"),
				new Customer(null, "Customer3", "789C", "987654321", "customer3@email.com"),
				new Customer(null, "Customer4", "111C", "666666666", "customer4@email.com")));

		// Check customers were saved correctly:
		for (Customer customer : customerRepo.findAll())
			System.out.println(customer);

		employeeRepo.saveAll(List.of(
				new Employee(null, "Employee1", "1111", "aa@aa.com", "123123123", "CEO", LocalDate.of(1990, 1, 2), LocalDate.of(2020, 1, 1), LocalDate.of(2022, 2, 2)),
				new Employee(null, "Employee2", "2222", "bb@bb.com", "456456456", "CTO", LocalDate.of(1995, 5, 9), LocalDate.of(2020, 2, 9), LocalDate.of(2022, 2, 2)),
				new Employee(null, "Employee3", "3333", "cc@cc.com", "789789789", "SEO", LocalDate.of(1998, 7, 12), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2))
		));
	}

}
