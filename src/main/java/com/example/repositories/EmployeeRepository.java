package com.example.repositories;

import com.example.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByName(String name);
    Optional<Employee> findByDni(String dni);
    Optional<Employee> findByPhone(String phone);
    Optional<Employee> findByEmail(String email);
    List<Employee> findAllByCompanyId(Long id);
}