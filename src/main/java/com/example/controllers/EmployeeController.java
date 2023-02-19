package com.example.controllers;

import com.example.entities.Employee;
import com.example.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("employees")
    public String findAll(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employee/employee-list";
    }
}
