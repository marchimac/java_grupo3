package com.example.services.impl;

import com.example.entities.Company;
import com.example.repositories.CompanyRepository;
import com.example.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepo;


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
        companyRepo.deleteById(id);
    }
}
