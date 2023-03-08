package com.example.controllers;

import com.example.entities.Company;
import com.example.repositories.EmployeeRepository;
import com.example.services.CompanyService;
import com.example.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class CompanyController {
    private final CompanyService companyService;
    private final EmployeeRepository employeeRepository;
    private final FileService fileService;

    @GetMapping("/")
    public String index() {
        return "layout/main";
    }

    @GetMapping("companies")
    public String findAll(Model model) {
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "company/company-list";
    }

    @GetMapping("companies/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Company> companyOpt = companyService.findById(id);
        if (companyOpt.isPresent()) {
            model.addAttribute("company", companyOpt.get());
        } else {
            model.addAttribute("error", "Not found");
        }

        return "company/company-detail";
    }

    @GetMapping("company/{id}/employees")
    public String showEmployeesByCompany(Model model, @PathVariable("id") Long id) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        model.addAttribute("employees", company.getEmployees());
        return "employee/employee-list";
    }

    @GetMapping("company/{id}/projects")
    public String showProjectsByCompany(Model model, @PathVariable("id") Long id) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        model.addAttribute("projects", company.getProjects());
        return "project/project-list";
    }



    @GetMapping("companies/create")
    public String createForm(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("companies", companyService.findAll());
        return "company/company-form";
    }

    @GetMapping("companies/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Company> companyOpt = companyService.findById(id);
        if (companyOpt.isPresent()) {
            model.addAttribute("company", companyOpt.get());
            model.addAttribute("companies", companyService.findAll());
        } else {
            model.addAttribute("error", "Not found");
        }

        return "company/company-form";
    }

    @PostMapping("companies")
    public String saveForm(Model model, @ModelAttribute Company company, @RequestParam("file") MultipartFile file) {
        if (file == null || file.isEmpty()) {
            companyService.save(company);
            return "redirect:/companies";
        }

        try {
            String fileName = fileService.storeInFileSystem(file);
            company.setImageUrl(fileName); // string
            companyService.save(company);
            return "redirect:/companies"; // redirección a controlador findAll
        } catch (Exception e) {
            model.addAttribute("error", "Failed to save image");
            model.addAttribute("companies", companyService.findAll());
            return "company/company-list";
        }
    }

    @GetMapping("companies/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        companyService.deleteById(id);
        return "redirect:/companies";
    }




}
