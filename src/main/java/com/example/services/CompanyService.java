package com.example.services;

import com.example.entities.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> findAll();
    Optional<Company> findById(Long id);
    List<Company> findByName(String name);
    Company save(Company company);
    void deleteById(Long id);

    List<Company> findByAddress_Country(String country);
}
