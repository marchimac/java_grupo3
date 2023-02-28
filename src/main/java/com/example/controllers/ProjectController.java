package com.example.controllers;

import com.example.entities.Project;
import com.example.services.CompanyService;
import com.example.services.CustomerService;
import com.example.services.ProjectService;
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
public class ProjectController {
    private final ProjectService projectService;
    private final CompanyService companyService;
    private final CustomerService customerService;

    @GetMapping("projects")
    public String findAll(Model model) {
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "project/project-list";
    }

    @GetMapping("projects/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Project> projectOpt = projectService.findById(id);
        if (projectOpt.isPresent()) {
            model.addAttribute("project", projectOpt.get());
        } else {
            model.addAttribute("error", "Project not found");
        }

        return "project/project-detail";
    }

    @GetMapping("projects/create")
    public String createForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("companies", companyService.findAll());
        model.addAttribute("customers", customerService.findAll());
        return "project/project-form";
    }

    @GetMapping("projects/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Project> projectOpt = projectService.findById(id);
        if (projectOpt.isPresent()) {
            model.addAttribute("project", projectOpt.get());
            model.addAttribute("companies", companyService.findAll());
            model.addAttribute("customers", customerService.findAll());
        } else {
            model.addAttribute("error", "Project not found");
        }

        return "project/project-form";
    }

    @PostMapping("projects")
    public String saveForm(@ModelAttribute Project project) {
        projectService.save(project);
        return "redirect:/projects";
    }

    @GetMapping("projects/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        projectService.deleteById(id);
        return "redirect:/projects";
    }
}
