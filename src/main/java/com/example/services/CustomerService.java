package com.example.services;

import com.example.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    // CRUD
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Optional<Customer> findByName(String name);
    Optional<Customer> findByCif(String cif);
    Optional<Customer> findByPhone(String phone);
    Optional<Customer> findByEmail(String email);
    Customer save(Customer customer);
    void deleteById(Long id);

}
