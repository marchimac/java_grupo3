package com.example.controllers;


import com.example.entities.Project;
import com.example.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("projects")
    public String findAll(Model model) {
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "project-list";
    }

    @GetMapping("projects/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Project> projectOpt = projectService.findById(id);
        if (projectOpt.isPresent())
            model.addAttribute("project", projectOpt.get());
        else
            model.addAttribute("error", "Project not found");
        return "project/project-detail";
    }

//    @GetMapping("projects/create")  Not sure about this
//    public String createForm(Model model) {
//        Project project = new Project();
//        project.setCompany(new Company);
//    }

//    @GetMapping("projects/{id}/edit")
//    public String editForm(Model model, @PathVariable Long id) {
//        Optional<Project> projectOpt = projectService.findById(id);
//        if (projectOpt.isPresent())
//            model.addAttribute("project", projectOpt.get());
//        else
//            model.addAttribute("error", "Project not found");
//        return "project/project-form";
//    }


}
