package com.example.services;

import com.example.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
}
