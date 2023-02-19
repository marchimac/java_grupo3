package com.example;

import com.example.entities.*;
import com.example.repositories.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class App {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(App.class, args);

		AddressRepository addressRepo = context.getBean(AddressRepository.class);
		EmployeeRepository employeeRepo = context.getBean(EmployeeRepository.class);
		ProjectRepository projectRepo = context.getBean(ProjectRepository.class);
		CompanyRepository companyRepo = context.getBean(CompanyRepository.class);
		CustomerRepository customerRepo = context.getBean(CustomerRepository.class);

				Address address1 = new Address(null, "Calle 1", "11111", "City 1", "Country 1");
				Address address2 = new Address(null, "Calle 2", "22222", "City 2", "Country 2");
				Address address3 = new Address(null, "Calle 3", "33333", "City 3", "Country 3");
				Address address4 = new Address(null, "Calle 4", "44444", "City 4", "Country 4");
				addressRepo.saveAll(List.of(address1, address2, address3, address4));

				Employee employee1 = new Employee(null, "Employee1", "1111", "aa@aa.com", "123123123", "CEO", LocalDate.of(1990, 1, 2), LocalDate.of(2020, 1, 1), LocalDate.of(2022, 2, 2));
				Employee employee2 = new Employee(null, "Employee2", "2222", "bb@bb.com", "456456456", "CTO", LocalDate.of(1995, 5, 9), LocalDate.of(2020, 2, 9), LocalDate.of(2022, 2, 2));
				Employee employee3 = new Employee(null, "Employee3", "3333", "cc@cc.com", "789789789", "SEO", LocalDate.of(1998, 7, 12), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2));
				employeeRepo.saveAll(List.of(employee1, employee2, employee3));

				Project project1 = new Project(null, "Project1", "webapp1", LocalDate.of(2021, 1, 1), LocalDate.of(2023, 12, 2), 2000.0);
				Project project2 = new Project(null, "Project2", "webapp2", LocalDate.of(2022, 2, 2), LocalDate.of(2022, 12, 2), 4000.0);
				Project project3 = new Project(null, "Project3", "webapp3", LocalDate.of(2023, 3, 3), LocalDate.of(2022, 12, 2), 4000.0);
				Project project4 = new Project(null, "Project4", "webapp4", LocalDate.of(2024, 4, 4), LocalDate.of(2022, 12, 2), 4000.0);
				projectRepo.saveAll(List.of(project1, project2, project3, project4));

				Company company1 = new Company(null, "Company1", "Slogan1", "url1", "linkedIn1", "Twitter1", "11111111A", address1, Set.of(employee1, employee2), Set.of(project1, project4));
				Company company2 = new Company(null, "Company2", "Slogan2", "url2", "linkedIn2", "Twitter2", "22222222B", address2, Set.of(employee2, employee3), Set.of(project2, project3));
				Company company3 = new Company(null, "Company3", "Slogan3", "url3", "linkedIn3", "Twitter3", "33333333C", address3, Set.of(employee1, employee2, employee3), Set.of(project1, project3));
				Company company4 = new Company(null, "Company4", "Slogan4", "url4", "linkedIn4", "Twitter4", "44444444D", address4, Set.of(employee1, employee3), Set.of(project1, project2, project3, project4));
				companyRepo.saveAll(List.of(company1, company2, company3, company4));

				Customer customer1 = new Customer(null, "Customer1", "123A", "123456789", "customer1@email.com");
				Customer customer2 = new Customer(null, "Customer2", "456B", "987654321", "customer2@email.com");
				Customer customer3 = new Customer(null, "Customer3", "789C", "987654321", "customer3@email.com");
				Customer customer4 = new Customer(null, "Customer4", "111C", "666666666", "customer4@email.com");
				customerRepo.saveAll(List.of(customer1, customer2, customer3, customer4));

	}

}
