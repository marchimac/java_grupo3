package com.example.controllers;

import com.example.entities.Employee;
import com.example.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("employees/{id}") // http://localhost:8080/employees/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Employee> employeeOpt = employeeService.findById(id);
        if (employeeOpt.isPresent())
            model.addAttribute("employee", employeeOpt.get());
        else
            model.addAttribute("error", "Employee not found");

        return "employee/employee-detail";
    }


}