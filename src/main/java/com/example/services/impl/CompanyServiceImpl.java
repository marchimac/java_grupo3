package com.example.services.impl;

import com.example.entities.Address;
import com.example.entities.Company;
import com.example.entities.Employee;
import com.example.entities.Project;
import com.example.repositories.CompanyRepository;
import com.example.services.AddressService;
import com.example.services.CompanyService;
import com.example.services.EmployeeService;
import com.example.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepo;
    private final AddressService addressService;
    private final EmployeeService employeeService;
    private final ProjectService projectService;


    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepo.findById(id);
    }

    @Override
    public List<Company> findByName(String name) {
        return companyRepo.findByName(name);
    }

    @Override
    public Company save(Company company) {
        return companyRepo.save(company);
    }

    @Override
    public void deleteById(Long id) {

        List<Employee> employees = employeeService.findAllByCompanyId(id);
        for (Employee employee : employees) {
            employee.setCompany(null);
        }
        employeeService.saveAll(employees);


        List<Address> addresses = addressService.findAllByCompanyId(id);
        for (Address address : addresses) {
            address.setCompany(null);
        }
        addressService.saveAll(addresses);


        List<Project> projects = projectService.findAllByCompanyId(id);
        for (Project project : projects) {
            project.setCompany(null);
        }
        projectService.saveAll(projects);


        companyRepo.deleteById(id);
    }

    @Override
    public List<Company> findByAddress_Country(String country) {
        return companyRepo.findByAddress_Country(country);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepo.getCompanyById(id);
    }
}
