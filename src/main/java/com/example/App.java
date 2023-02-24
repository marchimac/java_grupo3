package com.example;

import com.example.entities.*;
import com.example.entities.enums.Priority;
import com.example.entities.enums.Status;
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

        EmployeeRepository employeeRepo = context.getBean(EmployeeRepository.class);
        ProjectRepository projectRepo = context.getBean(ProjectRepository.class);
        CompanyRepository companyRepo = context.getBean(CompanyRepository.class);
        CustomerRepository customerRepo = context.getBean(CustomerRepository.class);
        TaskRepository taskRepo = context.getBean(TaskRepository.class);

        Address address1 = new Address(null, "Patricio nº1", "28086", "Madrid", "Spain", null, null);
        Address address2 = new Address(null, "Avenida América 47", "28965", "Madrid", "Spain", null, null);
        Address address3 = new Address(null, "Gran Vía Escultor Francisco Salzillo 45", "30954", "Murcia", "Spain", null, null);
        Address address4 = new Address(null, "Castellana 44", "28210", "Madrid", "Spain", null, null);
        Address address5 = new Address(null, "Ramblas 25", "08933", "Barcelona", "Spain", null, null);
        Address address6 = new Address(null, "Paseo el Grande 89", "05987", "Ávila", "Spain", null, null);
        Address address7 = new Address(null, "Calle Mohaja 17", "04212", "Almería", "Spain", null, null);
        Address address8 = new Address(null, "Calle 8", "88888", "City 8", "Country 8", null, null);
        Address address9 = new Address(null, "Calle 9", "99999", "City 9", "Country 9", null, null);
        Address address10 = new Address(null, "Calle 10", "101010", "City 10", "Country 10", null, null);
        Address address11 = new Address(null, "Calle 11", "111111", "City 11", "Country 11", null, null);

        Company company1 = new Company(null, "Accentur S.L.", "El valor se demuestra trabajando", "accentur@accentur.com", "linkedIn1", "Twitter1", "G6974740", address1, null, null);
        Company company2 = new Company(null, "Marcanast LTD", "Soluciones sin problemas", "marcanast@marcaset.com", "linkedIn2", "Twitter2", "B9487364", address2, null, null);
        Company company3 = new Company(null, "Biotech plus", "La vida por venir y vivir", "biotech@biostats.com", "linkedIn3", "Twitter3", "A8762078", address3, null, null);
        Company company4 = new Company(null, "Allion", "Contigo y para ti", "aillon@aillon.es", "linkedIn4", "Twitter4", "P9878786", address4, null, null);
        companyRepo.saveAll(List.of(company1, company2, company3, company4));

        Employee employee1 = new Employee(null, "Francisco Arribas", "07675437B", "admin", "fran@gmail.com", "678765432", "CEO", LocalDate.of(1990, 1, 2), LocalDate.of(2020, 1, 1), LocalDate.of(2020, 2, 2), address5, company1, null, null);
        Employee employee2 = new Employee(null, "Marcos Beltrán", "89123845W", "admin", "beltran454@gmail.com", "656456456", "CTO", LocalDate.of(1995, 5, 9), LocalDate.of(2020, 2, 9), LocalDate.of(2021, 2, 2), address6, company2, null, null);
        Employee employee3 = new Employee(null, "Sofía Álvarez", "43564321M", "admin", "sofia1978@@gmail.com", "789789789", "SEO", LocalDate.of(1998, 7, 12), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2), address7, company1, null, null);
        employeeRepo.saveAll(List.of(employee1, employee2, employee3));

        Project project1 = new Project(null, "Project1", "webapp1", LocalDate.of(2021, 1, 1), LocalDate.of(2023, 12, 2), 2000.0, company1);
        Project project2 = new Project(null, "Project2", "webapp2", LocalDate.of(2022, 2, 2), LocalDate.of(2022, 12, 2), 4000.0, company3);
        Project project3 = new Project(null, "Project3", "webapp3", LocalDate.of(2023, 3, 3), LocalDate.of(2021, 12, 2), 4000.0, company2);
        Project project4 = new Project(null, "Project4", "webapp4", LocalDate.of(2024, 4, 4), LocalDate.of(2020, 12, 2), 4000.0, company2);
        projectRepo.saveAll(List.of(project1, project2, project3, project4));

        Customer customer1 = new Customer(null, "Customer1", "123A", address8, "123456789", "customer1@email.com");
        Customer customer2 = new Customer(null, "Customer2", "456B", address9, "987654321", "customer2@email.com");
        Customer customer3 = new Customer(null, "Customer3", "789C", address10, "468526445", "customer3@email.com");
        Customer customer4 = new Customer(null, "Customer4", "111C", address11, "666666666", "customer4@email.com");
        customerRepo.saveAll(List.of(customer1, customer2, customer3, customer4));

        Task task1 = new Task(null, "Task1", "Description1", LocalDate.of(2019, 1, 1), project1, employee1, Status.WAITING, Priority.MEDIUM);
        Task task2 = new Task(null, "Task2", "Description2", LocalDate.of(2020, 2, 2), project2, employee2, Status.PENDING, Priority.LOW);
        Task task3 = new Task(null, "Task3", "Description3", LocalDate.of(2021, 3, 3), project3, employee3, Status.IN_PROGRESS, Priority.HIGH);
        taskRepo.saveAll(List.of(task1, task2, task3));
    }

}
