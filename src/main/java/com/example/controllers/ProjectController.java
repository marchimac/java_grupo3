package com.example.controllers;


import com.example.entities.Project;
import com.example.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
}
