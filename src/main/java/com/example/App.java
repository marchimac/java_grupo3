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
import java.util.Set;

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
        Address address2 = new Address(null, "Stoughton Lane 98", "82304", "Brinje", "Croatia", null, null);
        Address address3 = new Address(null, "Gran Vía Escultor Francisco Salzillo 45", "30954", "Murcia", "Spain", null, null);
        Address address4 = new Address(null, "Castellana 44", "28210", "Madrid", "Spain", null, null);
        Address address5 = new Address(null, "Ramblas 25", "08933", "Barcelona", "Spain", null, null);
        Address address6 = new Address(null, "Paseo El Grande 89", "05987", "Ávila", "Spain", null, null);
        Address address7 = new Address(null, "Service Center 20", "17641", "Nanning", "China", null, null);
        Address address8 = new Address(null, "Birchwood Alley 836", "35993", "London", "United Kingdom", null, null);
        Address address9 = new Address(null, "Ramsey Terrace 7", "24444", "Kanal", "Slovenia", null, null);
        Address address10 = new Address(null, "Kings Road 7", "85815", "København", "Denmark", null, null);
        Address address11 = new Address(null, "Union Court 362", "61500", "Līgatne", "Latvia", null, null);
        Address address12 = new Address(null, "Avenida Libertadores 261", "34781", "Valencia", "Spain", null, null);
        Address address13 = new Address(null, "Calle Mayor 2", "30110", "Albacete", "Spain", null, null);
        Address address14 = new Address(null, "Bellgrove Street 123", "57071", "París", "France", null, null);
        Address address15 = new Address(null, "Manley Pass 988", "57071", "Kovdor", "Russia", null, null);
        Address address16 = new Address(null, "Memorial Road 6", "91180", "Asintal", "Guatemala", null, null);
        Address address17 = new Address(null, "Moose Point 4", "61605", "Ilesa", "Nigeria", null, null);
        Address address18 = new Address(null, "Sundown Street 16", "18737", "Meruge", "Portugal", null, null);
        Address address19 = new Address(null, "Stuart Terrace 3", "67204", "San Diego", "United States", null, null);
        Address address20 = new Address(null, "John Wall Place 1048", "78281", "Kościerzyna", "Poland", null, null);
        Address address21 = new Address(null, "Bay Parkway 27", "42973", "Sop Moei", "Thailand", null, null);
        Address address22 = new Address(null, "Monterey Alley 6809", "89421", "Jeberos", "Perú", null, null);
        Address address23 = new Address(null, "Westridge Parkway 938", "34579", "Berlin", "Germany", null, null);
        Address address24 = new Address(null, "Hazelcrest Center 86", "72876", "Shimo-furano", "Japan", null, null);
        Address address25 = new Address(null, "Hansons Avenue 45", "15683", "Charleston", "United States", null, null);
        Address address26 = new Address(null, "Eliot Street 4", "87527", "Zubří", "Czech Republic", null, null);
        Address address27 = new Address(null, "Southridge Pass 672", "88096", "Apostolove", "Ukraine", null, null);
        Address address28 = new Address(null, "Sutteridge Road 45", "22787", "Sundbyberg", "Sweden", null, null);
        Address address29 = new Address(null, "Utah Parkway 639", "20981", "Kokkinóchoma", "Greece", null, null);
        Address address30 = new Address(null, "Londonderry Way 504", "89730", "El Retorno", "Colombia", null, null);

        Company company1 = new Company(null, "Accenture S.L.", "El valor se demuestra trabajando", "accenture@accenture.com", "https://www.lindedin.com/in/accenture", "http://twitter.com/accenture", "G6974740", address1, null, null);
        Company company2 = new Company(null, "Marcanast LTD", "Soluciones sin problemas", "marcanast@marcaset.com", "https://www.lindedin.com/in/marcanst", "http://twitter.com/marcanst", "B9487364", address2, null, null);
        Company company3 = new Company(null, "Biotech plus", "La vida por venir y vivir", "biotech@biostats.com", "https://www.lindedin.com/in/biotench", "http://twitter.com/biotech", "A8762078", address3, null, null);
        Company company4 = new Company(null, "Allion", "Contigo y para ti", "aillon@aillon.es", "https://www.lindedin.com/in/alion", "http://twitter.com/alion", "P9878786", address4, null, null);
        Company company5 = new Company(null, "Meeveo", "Transition 24/7 portals", "meeveo0@vinaora.com", "https://www.lindedin.com/in/meeveo", "http://twitter.com/meeveo", "H5432654", address5, null, null);
        Company company6 = new Company(null, "Pixonyx", "Reintermediate killer synergies", "pixonyx@xion.com", "https://www.lindedin.com/in/pixonyx", "http://twitter.com/pixonyx", "J8720984", address6, null, null);
        Company company7 = new Company(null, "Mynte", "Harness next-generation interfaces", "mynte@duybn.com", "https://www.lindedin.com/in/mynte", "http://twitter.com/mynte", "N7009333", address7, null, null);
        Company company8 = new Company(null, "Topdrive", "Matrix leading-edge bandwidth", "topdrive@topdrive.es", "https://www.lindedin.com/in/topdrive", "http://twitter.com/topdrive", "L0985087", address8, null, null);
        Company company9 = new Company(null, "Quaxo", "Utilize enterprise e-markets", "quaxo@quaxo.es", "https://www.lindedin.com/in/quaxo", "http://twitter.com/quaxo", "W3213878", address9, null, null);
        Company company10 = new Company(null, "Snaptags", "Maximize leading-edge action-items", "snap@tags.com", "https://www.lindedin.com/in/snaptags", "http://twitter.com/snaptags", "U7600790", address10, null, null);
        companyRepo.saveAll(List.of(company1, company2, company3, company4, company5, company6, company7, company8, company9, company10));

        Employee employee1 = new Employee(null, "Francisco Arribas", "07675437B", "admin", "fran@gmail.com", "180-536-1122", "CEO", LocalDate.of(1990, 1, 2), LocalDate.of(2015, 3, 6), LocalDate.of(2020, 2, 2), address11, company1, null, null);
        Employee employee2 = new Employee(null, "Marcos Beltrán", "89123845W", "admin", "beltran454@hotmail.com", "685-900-4475", "COO", LocalDate.of(1995, 5, 9), LocalDate.of(2020, 2, 7), LocalDate.of(2021, 2, 2), address12, company2, null, null);
        Employee employee3 = new Employee(null, "Sofía Álvarez", "43564321M", "admin", "sofia1978@hotmail.com", "970-260-4202", "CSO", LocalDate.of(1998, 7, 12), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2), address13, company3, null, null);
        Employee employee4 = new Employee(null, "Stanislaus Siege", "42576541Y", "admin", "stanissie_io@gmail.com", "825-102-7091", "CMO", LocalDate.of(1978, 10, 4), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2), address14, company4, null, null);
        Employee employee5 = new Employee(null, "Mariam Brearton", "76765439I", "admin", "brear-ton@yahoo.com", "383-504-7184", "CHRO", LocalDate.of(1999, 9, 22), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2), address15, company5, null, null);
        Employee employee6 = new Employee(null, "Erich Heffer", "13246400D", "admin", "heffererich@gmail.com", "910-852-5784", "CS", LocalDate.of(2001, 6, 2), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2), address16, company6, null, null);
        Employee employee7 = new Employee(null, "Alidia Muat", "87642341R", "admin", "aldiamuat@hotmail.com", "731-519-6884", "CFO", LocalDate.of(2001, 12, 21), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2), address17, company7, null, null);
        Employee employee8 = new Employee(null, "Vere Cable", "98985112F", "admin", "vere-verecable@gmail.com", "429-745-5060", "CSO", LocalDate.of(1980, 4, 19), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2), address18, company8, null, null);
        Employee employee9 = new Employee(null, "Fabio Branney", "90412314D", "admin", "branneyfabio@yahoo.com", "404-532-3192", "SEO", LocalDate.of(1967, 1, 25), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2), address19, company9, null, null);
        Employee employee10 = new Employee(null, "Nataline Ellen", "55332123V", "admin", "nata_line@gmail.com", "571-579-4759", "CMO", LocalDate.of(1997, 5, 13), LocalDate.of(2020, 8, 10), LocalDate.of(2022, 2, 2), address20, company10, null, null);
        employeeRepo.saveAll(List.of(employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9, employee10));

        Customer customer1 = new Customer(null, "Nealy Reasce", "78245362G", address21, "344-107-9293", "customer1@email.com", null);
        Customer customer2 = new Customer(null, "Camel Romain", "87623456B", address22, "958-858-4610", "customer2@email.com", null);
        Customer customer3 = new Customer(null, "Kermy Arnet", "90908789C", address23, "784-637-7443", "customer3@email.com", null);
        Customer customer4 = new Customer(null, "Duffie Etoile", "65453111C", address24, "968-984-3521", "customer4@email.com", null);
        Customer customer5 = new Customer(null, "Kipp Claris", "23123499H", address25, "988-239-9104", "customer4@email.com", null);
        Customer customer6 = new Customer(null, "Eben Schirok", "87653456T", address26, "391-306-9934", "customer4@email.com", null);
        Customer customer7 = new Customer(null, "Bartie Bolletti", "87112210J", address27, "685-105-4008", "customer4@email.com", null);
        Customer customer8 = new Customer(null, "Libbie Buche'", "65676468U", address28, "602-117-8073", "customer4@email.com", null);
        Customer customer9 = new Customer(null, "Hasty Quirk", "24108876N", address29, "615-546-8170", "customer4@email.com", null);
        Customer customer10 = new Customer(null, "Cybil Loddon", "87612312C", address30, "724-690-4673", "customer4@email.com", null);
        customerRepo.saveAll(List.of(customer1, customer2, customer3, customer4));

        Project project1 = new Project(null, "Project1", "webapp1", LocalDate.of(2021, 1, 1), LocalDate.of(2023, 12, 2), 2000.0, company1, customer1, null);
        Project project2 = new Project(null, "Project2", "webapp2", LocalDate.of(2022, 2, 2), LocalDate.of(2022, 12, 2), 4000.0, company3, customer2, null);
        Project project3 = new Project(null, "Project3", "webapp3", LocalDate.of(2023, 3, 3), LocalDate.of(2021, 12, 2), 4000.0, company2, customer3, null);
        Project project4 = new Project(null, "Project4", "webapp4", LocalDate.of(2024, 4, 4), LocalDate.of(2020, 12, 2), 4000.0, company2, customer4, null);
        projectRepo.saveAll(List.of(project1, project2, project3, project4));

        Task task1 = new Task(null, "Task1", "Description1", LocalDate.of(2019, 1, 1), project1, employee1, Status.WAITING, Priority.MEDIUM);
        Task task2 = new Task(null, "Task2", "Description2", LocalDate.of(2020, 2, 2), project2, employee2, Status.PENDING, Priority.LOW);
        Task task3 = new Task(null, "Task3", "Description3", LocalDate.of(2021, 3, 3), project3, employee3, Status.IN_PROGRESS, Priority.HIGH);
        taskRepo.saveAll(List.of(task1, task2, task3));
    }

}
