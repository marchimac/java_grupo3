package com.example.controllers;

import com.example.entities.Company;
import com.example.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class CompanyController {
    private final CompanyService companyService;

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
    public String saveForm(@ModelAttribute Company company) {
        companyService.save(company);
        return "redirect:/companies";
    }

    @GetMapping("companies/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        companyService.deleteById(id);
        return "redirect:/companies";
    }

}
