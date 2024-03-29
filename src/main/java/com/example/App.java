package com.example;

import com.example.entities.*;
import com.example.entities.enums.Priority;
import com.example.entities.enums.Status;
import com.example.repositories.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

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
        UserEntityRepository userRepository = context.getBean(UserEntityRepository.class);
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);

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
        Address address31 = new Address(null, "Broadway 123", "10001", "New York", "United States", null, null);
        Address address32 = new Address(null, "Main Street 456", "90210", "Los Angeles", "United States", null, null);
        Address address33 = new Address(null, "Champs-Élysées 789", "75008", "Paris", "France", null, null);
        Address address34 = new Address(null, "Savignyplatz 1", "10623", "Berlin", "Germany", null, null);
        Address address35 = new Address(null, "Via Montenapoleone 8", "20121", "Milan", "Italy", null, null);
        Address address36 = new Address(null, "Gran Vía 1", "28013", "Madrid", "Spain", null, null);
        Address address37 = new Address(null, "Ginza 4-1", "104-0061", "Tokyo", "Japan", null, null);
        Address address38 = new Address(null, "Paseo de la Reforma 222", "06600", "Mexico City", "Mexico", null, null);
        Address address39 = new Address(null, "Avenida Paulista 1234", "01310-100", "São Paulo", "Brazil", null, null);
        Address address40 = new Address(null, "Oxford Street 123", "W1D 1BS", "London", "United Kingdom", null, null);
        Address address41 = new Address(null, "Nieuwendijk 196", "1012 MJ", "Amsterdam", "Netherlands", null, null);
        Address address42 = new Address(null, "Kärntner Straße 1", "1010", "Vienna", "Austria", null, null);
        Address address43 = new Address(null, "Calle Florida 343", "C1005AAH", "Buenos Aires", "Argentina", null, null);
        Address address44 = new Address(null, "Rue du Faubourg Saint-Honoré 101", "75008", "Paris", "France", null, null);
        Address address45 = new Address(null, "Tverskaya ulitsa 9", "125009", "Moscow", "Russia", null, null);
        Address address46 = new Address(null, "Kingsway 123", "WC2B 6PP", "London", "United Kingdom", null, null);
        Address address47 = new Address(null, "Paseo de Gracia 92", "08008", "Barcelona", "Spain", null, null);
        Address address48 = new Address(null, "Chuo-dori 1", "260-8555", "Chiba", "Japan", null, null);
        Address address49 = new Address(null, "Avenida Presidente Masaryk 111", "11560", "Mexico City", "Mexico", null, null);
        Address address50 = new Address(null, "Schildergasse 45-47", "50667", "Cologne", "Germany", null, null);
        Address address51 = new Address(null, "Rue de la Paix 12", "75002", "Paris", "France", null, null);

        Company company1 = new Company(null, "Aperture S.L.", "El valor se demuestra trabajando", "aperture@aperture.com", "https://www.lindedin.com/in/aperture", "http://twitter.com/aperture", "G6974740", "Aperture.jpg", address1, null, null);
        Company company2 = new Company(null, "Marcanast LTD", "Soluciones sin problemas", "marcanast@marcaset.com", "https://www.lindedin.com/in/marcanst", "http://twitter.com/marcanst", "B9487364", "Marcanast.png", address2, null, null);
        Company company3 = new Company(null, "Biotech plus", "La vida por venir y vivir", "biotech@biostats.com", "https://www.lindedin.com/in/biotench", "http://twitter.com/biotech", "A8762078", "Biotech.jpg", address3, null, null);
        Company company4 = new Company(null, "Allion", "Contigo y para ti", "aillon@aillon.es", "https://www.lindedin.com/in/alion", "http://twitter.com/alion", "P9878786", "Allion.jpg", address4, null, null);
        Company company5 = new Company(null, "Meeveo", "Transition 24/7 portals", "meeveo0@vinaora.com", "https://www.lindedin.com/in/meeveo", "http://twitter.com/meeveo", "H5432654", "Meeveo.jpg", address5, null, null);
        Company company6 = new Company(null, "Pixonyx", "Reintermediate killer synergies", "pixonyx@xion.com", "https://www.lindedin.com/in/pixonyx", "http://twitter.com/pixonyx", "J8720984", "Pixonyx.jpg", address6, null, null);
        Company company7 = new Company(null, "Mynte", "Harness next-generation interfaces", "mynte@duybn.com", "https://www.lindedin.com/in/mynte", "http://twitter.com/mynte", "N7009333", "Mynte.jpg", address7, null, null);
        Company company8 = new Company(null, "Topdrive", "Matrix leading-edge bandwidth", "topdrive@topdrive.es", "https://www.lindedin.com/in/topdrive", "http://twitter.com/topdrive", "L0985087", "Topdrive.jpg", address8, null, null);
        Company company9 = new Company(null, "Quaxo", "Utilize enterprise e-markets", "quaxo@quaxo.es", "https://www.lindedin.com/in/quaxo", "http://twitter.com/quaxo", "W3213878", "Quaxo.jpg", address9, null, null);
        Company company10 = new Company(null, "Snaptags", "Maximize leading-edge action-items", "snap@tags.com", "https://www.lindedin.com/in/snaptags", "http://twitter.com/snaptags", "U7600790", "SnapTags.jpg", address10, null, null);
        Company company11 = new Company(null, "CyberCore", "Potenciando tus habilidades tecnológicas", "ciber@core.com", "https://www.lindedin.com/in/cibercore", "http://twitter.com/cibercore", "L7654090", "CyberCore.png", address11, null, null);
        Company company12 = new Company(null, "PixelWave", "Haciendo que el futuro se vea más brillante", "pixel@wave.com", "https://www.lindedin.com/in/pixelwave", "http://twitter.com/pixelwavw", "P1324597", "PixelWave.jpg", address12, null, null);
        Company company13 = new Company(null, "VirtualMind", "Conectando el mundo virtual con la realidad", "virtual@mind.com", "https://www.lindedin.com/in/virtualmind", "http://twitter.com/virtualmind", "L8962435", "VirtualMind.jpg", address13, null, null);
        Company company14 = new Company(null, "CodeGuru", "Dominando el código, conquistando el futuro", "code@guru.com", "https://www.lindedin.com/in/codeguru", "http://twitter.com/codeguru", "Y7845321", "CodeGuru.jpg", address14, null, null);
        Company company15 = new Company(null, "TechHive", "Innovación tecnológica en su máxima expresión", "tech@hive.com", "https://www.lindedin.com/in/techhive", "http://twitter.com/techhive", "O8976328", "TechHive.jpg", address15, null, null);
        companyRepo.saveAll(List.of(company1, company2, company3, company4, company5, company6, company7, company8, company9, company10, company11, company12, company13, company14, company15));

        Employee employee1 = new Employee(null, "Francisco Arribas", "07675437B", "fran@gmail.com", "180-536-1122", "CEO", LocalDate.of(1990, 1, 2), LocalDate.of(2015, 3, 6), "Francisco.jpg", address16, company1, null, null);
        Employee employee2 = new Employee(null, "Marcos Beltrán", "89123845W", "beltran454@hotmail.com", "685-900-4475", "COO", LocalDate.of(1995, 5, 9), LocalDate.of(2020, 2, 7), "Erich.jpg", address17, company3, null, null);
        Employee employee3 = new Employee(null, "Sofía Álvarez", "43564321M", "sofia1978@hotmail.com", "970-260-4202", "CSO", LocalDate.of(1998, 7, 12), LocalDate.of(2020, 8, 10), "Fabio.jpg", address18, company1, null, null);
        Employee employee4 = new Employee(null, "Stanislaus Siege", "42576541Y", "stanissie_io@gmail.com", "825-102-7091", "CMO", LocalDate.of(1978, 10, 4), LocalDate.of(2020, 8, 10), "Fabio.jpg", address19, company2, null, null);
        Employee employee5 = new Employee(null, "Mariam Brearton", "76765439I", "brear-ton@yahoo.com", "383-504-7184", "CHRO", LocalDate.of(1999, 9, 22), LocalDate.of(2020, 8, 10), "Fabio.jpg", address20, company2, null, null);
        Employee employee6 = new Employee(null, "Erich Heffer", "13246400D", "heffererich@gmail.com", "910-852-5784", "CS", LocalDate.of(2001, 6, 2), LocalDate.of(2020, 8, 10), "Erich.jpg", address21, company3, null, null);
        Employee employee7 = new Employee(null, "Alidia Muat", "87642341R", "aldiamuat@hotmail.com", "731-519-6884", "CFO", LocalDate.of(2001, 12, 21), LocalDate.of(2021, 4, 13), "Alidia.jpg", address22, company3, null, null);
        Employee employee8 = new Employee(null, "Vere Cable", "98985112F", "vere-verecable@gmail.com", "429-745-5060", "CSO", LocalDate.of(1980, 4, 19), LocalDate.of(2019, 3, 11), "Vere.jpg", address23, company4, null, null);
        Employee employee9 = new Employee(null, "Fabio Branney", "90412314D", "branneyfabio@yahoo.com", "404-532-3192", "SEO", LocalDate.of(1967, 1, 25), LocalDate.of(2020, 8, 10), "Fabio.jpg", address24, company4, null, null);
        Employee employee10 = new Employee(null, "Nataline Ellen", "55332123V", "nata_line@gmail.com", "571-579-4759", "CMO", LocalDate.of(1997, 5, 13), LocalDate.of(2020, 8, 10), "Nataline.jpg", address25, company5, null, null);
        Employee employee11 = new Employee(null, "Malissia Gingell", "101500144H", "mgingell0@slideshare.net", "471-856-1711", "CSO", LocalDate.of(1998, 1, 3), LocalDate.of(2020, 8, 10), "Casey.jpg", address26, company6, null, null);
        Employee employee12 = new Employee(null, "Hamlin Josefson", "102097275U", "hjosefson1@usnews.com", "330-699-5621", "CHRO", LocalDate.of(1999, 6, 1), LocalDate.of(2018, 5, 3), "Basilius.jpg", address27, company6, null, null);
        Employee employee13 = new Employee(null, "Casey Noddle", "34349206B", "cpatient2@europa.eu", "577-861-5084", "SEO", LocalDate.of(2003, 2, 7), LocalDate.of(2020, 8, 10), "Casey.jpg", address28, company6, null, null);
        Employee employee14 = new Employee(null, "Basilius Brameld", "27010822R", "tandino3@ftc.gov", "788-315-6709", "CSO", LocalDate.of(2001, 12, 26), LocalDate.of(2020, 4, 13), "Basilius.jpg", address29, company1, null, null);
        Employee employee15 = new Employee(null, "Candy Patient", "52486142T", "hhowsley4@hexun.com", "520-238-0186", "CFO", LocalDate.of(2002, 8, 29), LocalDate.of(2020, 10, 23), "Candy.jpg", address30, company7, null, null);
        Employee employee16 = new Employee(null, "Timmy Andino", "65649670E", "nmaccaull5@vinaora.com", "864-513-2161", "CS", LocalDate.of(2000, 5, 31), LocalDate.of(2020, 8, 10), "Marcos.jpg", address31, company7, null, null);
        Employee employee17 = new Employee(null, "Hamilton Howsley", "08911889D", "rmacilhargy6@hc360.com", "108-626-2993", "CHRO", LocalDate.of(1999, 12, 7), LocalDate.of(2020, 8, 10), "Marcos.jpg", address32, company7, null, null);
        Employee employee18 = new Employee(null, "Nicolas MacCaull", "98552782M", "rdoogood7@ucoz.com", "871-430-7153", "COO", LocalDate.of(2000, 2, 26), LocalDate.of(2020, 8, 10), "Marcos.jpg", address33, company7, null, null);
        Employee employee19 = new Employee(null, "Rose MacIlhargy", "46156828P", "obrice8@trellian.com", "570-746-5467", "CMO", LocalDate.of(2002, 12, 3), LocalDate.of(2020, 8, 10), "Rose.jpg", address34, company8, null, null);
        Employee employee20 = new Employee(null, "Regen Doogood", "34315212R", "gdomenicone9@wordpress.org", "360-715-5775", "CFO", LocalDate.of(2003, 12, 13), LocalDate.of(2020, 8, 10), "Marcos.jpg", address35, company8, null, null);
        Employee employee21 = new Employee(null, "Oralie Brice", "63400185A", "achstneyb@si.edu", "468-716-9141", "CFO", LocalDate.of(1993, 9, 23), LocalDate.of(2020, 8, 10), "Rose.jpg", address36, company9, null, null);
        Employee employee22 = new Employee(null, "Gwendolen Domenicone", "15373101Q", "cmcilwreathc@youku.com", "377-196-9477", "CEO", LocalDate.of(1975, 1, 6), LocalDate.of(2020, 8, 10), "Malissia.jpg", address37, company10, null, null);
        Employee employee23 = new Employee(null, "Zach Senechell", "53781039C", "msalmondd@g.co", "372-342-4310", "COO", LocalDate.of(1997, 9, 3), LocalDate.of(2020, 8, 10), "Marcos.jpg", address38, company10, null, null);
        Employee employee24 = new Employee(null, "Egan Thomann", "56251550M", "ethomanng@mlb.com", "899-773-4199", "CHRO", LocalDate.of(1993, 3, 30), LocalDate.of(2020, 8, 10), "Hamlin.jpg", address39, company10, null, null);
        employeeRepo.saveAll(List.of(employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9, employee10, employee11, employee12, employee13, employee14, employee15, employee16, employee17, employee18, employee19, employee20, employee21, employee22, employee23, employee24));

        Customer customer1 = new Customer(null, "Abraham Melano", "78245362G", address40, "344-107-9293", "nealyasce@gmail.com", "Stanislaus.jpg", null);
        Customer customer2 = new Customer(null, "Camile Romain", "87623456B", address41, "958-858-4610", "romaincamel@hotmail.com", "Sofia.jpg", null);
        Customer customer3 = new Customer(null, "Kermy Arnet", "90908789C", address42, "784-637-7443", "kerny-arnet@yahoo.com", "Stanislaus.jpg", null);
        Customer customer4 = new Customer(null, "Duffie Etoile", "65453111C", address43, "968-984-3521", "duffie@hotmail.com", "Malissia.jpg", null);
        Customer customer5 = new Customer(null, "Kipp Claris", "23123499H", address44, "988-239-9104", "kippclaris26@gmail.com", "Marcos.jpg", null);
        Customer customer6 = new Customer(null, "Eben Schirok", "87653456T", address45, "391-306-9934", "ebeneben@hotmail.com", "Mariam.jpg", null);
        Customer customer7 = new Customer(null, "Bartie Bolletti", "87112210J", address46, "685-105-4008", "bartielletti@yahoo.com", "Mariam.jpg", null);
        Customer customer8 = new Customer(null, "Libbie Buche'", "65676468U", address47, "602-117-8073", "buche524@gmail.com", "Sofia.jpg", null);
        Customer customer9 = new Customer(null, "Hasty Quirk", "24108876N", address48, "615-546-8170", "hasty-quirk@hotmail.com", "Erich.jpg", null);
        Customer customer10 = new Customer(null, "Cybil Loddon", "87612312C", address49, "724-690-4673", "cybil_loddon1978@gmail.com", "Francisco.jpg", null);
        Customer customer11 = new Customer(null, "Nealy Reasce", "23142312B", address50, "545-690-4673", "nealy-reasce1978@gmail.com", "Rose.jpg", null);
        Customer customer12 = new Customer(null, "Casius Clay", "90902312P", address51, "231-690-4673", "mohamedali1978@gmail.com", "Marcos.jpg", null);
        customerRepo.saveAll(List.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10, customer11, customer12));

        Project project1 = new Project(null, "CloudCore", "Cloud computing infrastructure management software", LocalDate.of(2022, 1, 1), LocalDate.of(2023, 12, 2), 200000.0, company1, customer1, null);
        Project project2 = new Project(null, "DataVision", "Big data visualization and analysis platform", LocalDate.of(2021, 2, 2), LocalDate.of(2024, 10, 2), 450000.0, company1, customer1, null);
        Project project3 = new Project(null, "CyberShield", "Cybersecurity threat detection and prevention software", LocalDate.of(2020, 3, 3), LocalDate.of(2025, 9, 19), 154000.0, company1, customer2, null);
        Project project4 = new Project(null, "PowerFlow", "Renewable energy management and optimization platform", LocalDate.of(2021, 4, 4), LocalDate.of(2023, 12, 28), 2674000.0, company2, customer2, null);
        Project project5 = new Project(null, "TechSavant", "AI-powered tech support and troubleshooting service", LocalDate.of(2018, 5, 5), LocalDate.of(2026, 12, 31), 875000.0, company3, customer3, null);
        Project project6 = new Project(null, "MindMeld", "Brain-computer interface technology for communication and control", LocalDate.of(2019, 6, 7), LocalDate.of(2023, 12, 31), 4000000.0, company4, customer4, null);
        Project project7 = new Project(null, "SynapseAI", "Machine learning platform for predictive analytics and automation", LocalDate.of(2023, 9, 24), LocalDate.of(2024, 12, 21), 775000.0, company5, customer5, null);
        Project project8 = new Project(null, "QuantumLink", "Quantum computing communication and networking solutions", LocalDate.of(2015, 12, 29), LocalDate.of(2023, 8, 2), 18000.0, company6, customer6, null);
        Project project9 = new Project(null, "NanoTech", "Nanotechnology development and application platform", LocalDate.of(2000, 10, 24), LocalDate.of(2024, 11, 22), 95000.0, company7, customer7, null);
        Project project10 = new Project(null, "SmartSight", "Computer vision technology for autonomous systems and robotics", LocalDate.of(2022, 1, 31), LocalDate.of(2020, 5, 3), 123000.0, company8, customer8, null);
        Project project11 = new Project(null, "Papallama", "Nessum dorma allea", LocalDate.of(2022, 1, 31), LocalDate.of(2020, 5, 3), 123000.0, company9, customer9, null);
        Project project12 = new Project(null, "Latinus", "Allea non regit me", LocalDate.of(2022, 1, 31), LocalDate.of(2020, 5, 3), 123000.0, company10, customer10, null);
        projectRepo.saveAll(List.of(project1, project2, project3, project4, project5, project6, project7, project8, project9, project10, project11, project12));

        Task task1 = new Task(null, "CodeCrush", "Debugging and troubleshooting software development issues", LocalDate.of(2019, 1, 1), project1, employee1, Status.COMPLETED, Priority.MEDIUM);
        Task task2 = new Task(null, "PixelPerfect", "User interface design and optimization", LocalDate.of(2024, 2, 2), project5, employee2, Status.PENDING, Priority.LOW);
        Task task3 = new Task(null, "DataMaven", "Data cleaning, analysis, and modeling", LocalDate.of(2025, 3, 3), project2, employee3, Status.IN_PROGRESS, Priority.HIGH);
        Task task4 = new Task(null, "CloudMaster", "Cloud infrastructure design and management", LocalDate.of(2023, 5, 3), project4, employee4, Status.IN_PROGRESS, Priority.CRITICAL);
        Task task5 = new Task(null, "TechScout", "Research and development of emerging technologies", LocalDate.of(2023, 3, 1), project3, employee5, Status.COMPLETED, Priority.CRITICAL);
        Task task6 = new Task(null, "CyberDefend", "Cybersecurity threat analysis and response", LocalDate.of(2023, 7, 31), project6, employee6, Status.IN_PROGRESS, Priority.HIGH);
        Task task7 = new Task(null, "DevOpsPro", "DevOps process optimization and automation", LocalDate.of(2024, 10, 12), project7, employee7, Status.CANCELED, Priority.LOW);
        Task task8 = new Task(null, "TestGenius", "Software testing and quality assurance", LocalDate.of(2023, 9, 21), project9, employee8, Status.IN_PROGRESS, Priority.MEDIUM);
        Task task9 = new Task(null, "AIWizard", "Artificial intelligence development and integration", LocalDate.of(2022, 12, 31), project8, employee9, Status.COMPLETED, Priority.HIGH);
        Task task10 = new Task(null, "TechRevamp", "Legacy system modernization and transformation", LocalDate.of(2026, 3, 3), project10, employee10, Status.CANCELED, Priority.CRITICAL);
        Task task11 = new Task(null, "NanoGen", "Nanobot generator system", LocalDate.of(2023, 1, 9), project2, employee11, Status.COMPLETED, Priority.CRITICAL);
        Task task12 = new Task(null, "QuantumLeap", "Quantum computing platform", LocalDate.of(2008, 12, 12), project4, employee12, Status.CANCELED, Priority.HIGH);
        Task task13 = new Task(null, "BrainWave", "Mind-controlled interface technology", LocalDate.of(2020, 9, 30), project6, employee13, Status.IN_PROGRESS, Priority.MEDIUM);
        Task task14 = new Task(null, "AeroDyne", "Autonomous flying drone fleet", LocalDate.of(2021, 5, 25), project8, employee14, Status.PENDING, Priority.CRITICAL);
        Task task15 = new Task(null, "BioSim", "Biomedical simulation software", LocalDate.of(1999, 9, 17), project10, employee15, Status.COMPLETED, Priority.LOW);
        Task task16 = new Task(null, "CyberGuard", "Advanced cybersecurity suite", LocalDate.of(2004, 11, 30), project9, employee16, Status.IN_PROGRESS, Priority.HIGH);
        Task task17 = new Task(null, "SolarX", "Solar-powered electric vehicle\n", LocalDate.of(2024, 4, 28), project6, employee17, Status.PENDING, Priority.CRITICAL);
        Task task18 = new Task(null, "SmartHome", "Intelligent home automation system\n", LocalDate.of(2025, 8, 22), project5, employee18, Status.CANCELED, Priority.MEDIUM);
        Task task19 = new Task(null, "BioFueler", "Algae-based biofuel production", LocalDate.of(1997, 10, 4), project1, employee19, Status.CANCELED, Priority.MEDIUM);
        Task task20 = new Task(null, "MindMesh", "Neural network modeling software", LocalDate.of(2021, 12, 3), project3, employee20, Status.COMPLETED, Priority.LOW);
        Task task21 = new Task(null, "SkyView", "Satellite imagery analysis platform", LocalDate.of(2023, 8, 5), project10, employee21, Status.COMPLETED, Priority.HIGH);
        Task task22 = new Task(null, "GeoTrack", "Real-time GPS tracking system\n", LocalDate.of(2021, 1, 7), project3, employee22, Status.CANCELED, Priority.CRITICAL);
        Task task23 = new Task(null, "HealthHub", "Personalized health monitoring device", LocalDate.of(2009, 9, 30), project9, employee23, Status.PENDING, Priority.LOW);
        Task task24 = new Task(null, "GreenGen", "Renewable energy grid optimization", LocalDate.of(2022, 9, 3), project5, employee24, Status.CANCELED, Priority.CRITICAL);
        taskRepo.saveAll(List.of(task1, task2, task3, task4, task5, task6, task7, task8, task9, task10, task11, task12, task13, task14, task15, task16, task17, task18, task19, task20, task21, task22, task23, task24));

        String encodedBeatriz = passwordEncoder.encode("admin");
        String encodedItziar = passwordEncoder.encode("admin");
        String encodedJuanjo = passwordEncoder.encode("admin");
        String encodedJavi = passwordEncoder.encode("admin");
        String encodedFernando = passwordEncoder.encode("admin");
        UserEntity beatriz = new UserEntity(null, "Beatriz", "beatriz@grath.com", encodedBeatriz);
        UserEntity itziar = new UserEntity(null, "Itziar", "itziar@grath.com", encodedItziar);
        UserEntity juanjo = new UserEntity(null, "Juanjo", "juanjo@grath.com", encodedJuanjo);
        UserEntity javi = new UserEntity(null, "Javi", "javi@grath.com", encodedJavi);
        UserEntity fernando = new UserEntity(null, "Fernando", "fernando@grath.com", encodedFernando);
        userRepository.saveAll(List.of(beatriz, itziar, juanjo, javi, fernando));
    }

}