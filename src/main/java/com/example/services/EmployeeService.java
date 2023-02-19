package com.example.services;

import com.example.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Optional<Employee> findByName(String name);
    Optional<Employee> findByDni(String dni);
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByPhone(String phone);
    Optional<Employee> findByPosition(String position);
    Employee save(Employee employee);
    void deleteById(Long id);
}
