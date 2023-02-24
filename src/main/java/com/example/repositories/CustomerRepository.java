package com.example.repositories;

import com.example.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findAllByName(String name);
    Optional<Customer> findByCif(String cif);
    Optional<Customer> findByPhone(String phone);
    Optional<Customer> findByEmail(String email);

}