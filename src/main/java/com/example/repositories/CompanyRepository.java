package com.example.repositories;

import com.example.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByName(String name);

    List<Company> findByAddress_Country(String country);

    Company getCompanyById(Long id);
}