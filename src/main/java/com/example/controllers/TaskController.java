package com.example.controllers;

import com.example.entities.Task;
import com.example.services.EmployeeService;
import com.example.services.ProjectService;
import com.example.services.TaskService;
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
public class TaskController {
    private final TaskService taskService;
    private final ProjectService projectService;
    private final EmployeeService employeeService;

    @GetMapping("tasks")
    public String findAll(Model model) {
        List<Task> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);
        return "task/task-list";
    }

    @GetMapping("tasks/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Task> taskOpt = taskService.findById(id);
        if (taskOpt.isPresent()) {
            model.addAttribute("task", taskOpt.get());
        } else {
            model.addAttribute("error", "Not found");
        }

        return "task/task-detail";
    }

    @GetMapping("tasks/create")
    public String createForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", employeeService.findAll());
        return "task/task-form";
    }

    @GetMapping("tasks/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Task> taskOpt = taskService.findById(id);
        if (taskOpt.isPresent()) {
            model.addAttribute("task", taskOpt.get());
            model.addAttribute("projects", projectService.findAll());
            model.addAttribute("employees", employeeService.findAll());
        } else {
            model.addAttribute("error", "Not found");
        }

        return "task/task-form";
    }

    @PostMapping("tasks")
    public String saveForm(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("tasks/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
        return "redirect:/tasks";
    }
}
