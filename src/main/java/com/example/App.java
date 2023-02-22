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

        Address address1 = new Address(null, "Patricio nº1", "28086", "Madrid", "Spain");
        Address address2 = new Address(null, "Avna. América 47", "28965", "Madrid", "Spain");
        Address address3 = new Address(null, "Gran Vía Escultor Francisco Salzillo 45", "30954", "Murcia", "<Spain3");
        Address address4 = new Address(null, "Castellana 44", "28210", "Madrid", "Spain");
        Address address5 = new Address(null, "Ramblas 25", "08933", "Barcelona", "Spain");
        Address address6 = new Address(null, "Paseo el Grande 89", "05987", "Ávila", "Spain");
        Address address7 = new Address(null, "Calle Mohaja 17", "04212", "Almería", "Spain");
        addressRepo.saveAll(List.of(address1, address2, address3, address4, address5, address6, address7));

        Company company1 = new Company(null, "Acentur SL", "El valor se demuestra trabajando", "acentur@acentur.com", "linkedIn1", "Twitter1", "G6974740", address1, null, null);
        Company company2 = new Company(null, "Marcanast LTD", "Soluciones sin problemas", "marcanast@marcaset.com", "linkedIn2", "Twitter2", "B9487364", address2, null, null);
        Company company3 = new Company(null, "Biotech plus", "La vida por venir y vivir", "biotech@biostats.com", "linkedIn3", "Twitter3", "A8762078", address3, null, null);
        Company company4 = new Company(null, "Allion", "Contigo y para ti", "aillon@aillon.es", "linkedIn4", "Twitter4", "P9878786", address4, null, null);
        companyRepo.saveAll(List.of(company1, company2, company3, company4));

        Employee employee1 = new Employee(null, "Francisco Arribas", "07675437B", "admin", "fran@gmail.com", "678765432", address5, "RRHH", LocalDate.of(1990, 1, 2), LocalDate.of(2020, 1, 1), LocalDate.of(2020, 2, 2), company1);
        Employee employee2 = new Employee(null, "Marcos Beltrán", "089123845W", "admin", "beltran454@gmail.com", "656456456", address6,  "CTO", LocalDate.of(1995, 5, 9), LocalDate.of(2020, 2, 9), LocalDate.of(2021, 2, 2), company2);
        Employee employee3 = new Employee(null, "Sofia Alvarez", "0643564321M", "admin", "sofia1978@@gmail.com", "789789789", address7, "Copy", LocalDate.of(1998, 7, 12), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2), company1);
        employeeRepo.saveAll(List.of(employee1, employee2, employee3));

        Project project1 = new Project(null, "Project1", "webapp1", LocalDate.of(2021, 1, 1), LocalDate.of(2023, 12, 2), 2000.0, company1);
        Project project2 = new Project(null, "Project2", "webapp2", LocalDate.of(2022, 2, 2), LocalDate.of(2022, 12, 2), 4000.0, company3);
        Project project3 = new Project(null, "Project3", "webapp3", LocalDate.of(2023, 3, 3), LocalDate.of(2021, 12, 2), 4000.0, company2);
        Project project4 = new Project(null, "Project4", "webapp4", LocalDate.of(2024, 4, 4), LocalDate.of(2020, 12, 2), 4000.0, company2);
        projectRepo.saveAll(List.of(project1, project2, project3, project4));


        Customer customer1 = new Customer(null, "Customer1", "123A", address1, "123456789", "customer1@email.com");
        Customer customer2 = new Customer(null, "Customer2", "456B", address2, "987654321", "customer2@email.com");
        Customer customer3 = new Customer(null, "Customer3", "789C", address3, "468526445", "customer3@email.com");
        Customer customer4 = new Customer(null, "Customer4", "111C", address4, "666666666", "customer4@email.com");
        customerRepo.saveAll(List.of(customer1, customer2, customer3, customer4));

    }

}
