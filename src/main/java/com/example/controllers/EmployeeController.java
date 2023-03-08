package com.example.controllers;

import com.example.entities.Address;
import com.example.entities.Employee;
import com.example.services.CompanyService;
import com.example.services.EmployeeService;
import com.example.services.FileService;
import com.example.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CompanyService companyService;
    private final ProjectService projectService;
    private final FileService fileService;

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

    @GetMapping("employees/create")
    public String createForm(Model model) {
        Employee employee = new Employee();
        employee.setAddress(new Address());
        model.addAttribute("employee", employee);
        model.addAttribute("companies", companyService.findAll());
        model.addAttribute("projects", projectService.findAll());
        return "employee/employee-form";
    }

    @GetMapping("employees/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Employee> employeeOpt = employeeService.findById(id);
        if (employeeOpt.isPresent()) {
            model.addAttribute("employee", employeeOpt.get());
            model.addAttribute("companies", companyService.findAll());
            model.addAttribute("projects", projectService.findAll());
        } else {
            model.addAttribute("error", "Employee not found");
        }

        return "employee/employee-form";
    }

    @PostMapping("employees")
    public String saveForm(Model model, @ModelAttribute Employee employee, @RequestParam("file")MultipartFile file) {
        if (file == null || file.isEmpty()) {
            employeeService.save(employee);
            return "redirect:/employees";
        }

        try {
            String fileName = fileService.storeInFileSystem(file);
            employee.setImageUrl(fileName); // string
            employeeService.save(employee);
            return "redirect:/employees"; // redirección a controlador findAll
        } catch (Exception e) {
            model.addAttribute("error", "Failed to save image");
            model.addAttribute("employees", employeeService.findAll());
            return "employee/employee-list";
        }

    }

    @GetMapping("employees/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
}