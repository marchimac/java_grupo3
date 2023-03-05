package com.example.controllers;

import com.example.entities.Task;
import com.example.entities.enums.Priority;
import com.example.entities.enums.Status;
import com.example.services.EmployeeService;
import com.example.services.ProjectService;
import com.example.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class TaskController {

    private final TaskService taskService;
    private final ProjectService projectService;
    private final EmployeeService employeeService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("tasks")
    public String findAll(Model model) {
        List<Task> tasks = taskService.findAll();
        List<String> statusMessages = new ArrayList<>();
        List<String> priorityMessages = new ArrayList<>();
        for (Task task : tasks) {
            String statusMessage = messageSource.getMessage("status." + task.getStatus().name(), null, Locale.ENGLISH);
            String priorityMessage = messageSource.getMessage("priority." + task.getPriority().name(), null, Locale.ENGLISH);
            statusMessages.add(statusMessage);
            priorityMessages.add(priorityMessage);
        }
        model.addAttribute("tasks", tasks);
        model.addAttribute("statusMessages", statusMessages);
        model.addAttribute("priorityMessages", priorityMessages);
        return "task/task-list";
    }


    @GetMapping("tasks/status/{status}")
    public String findAllByStatus(@PathVariable String status, Model model) {
        List<Task> tasks = taskService.findAllByStatus(Status.valueOf(status.toUpperCase()));
        List<String> statusMessages = new ArrayList<>();
        for (Task task : tasks) {
            String statusMessage = messageSource.getMessage("status." + task.getStatus().name(), null, Locale.ENGLISH);
            statusMessages.add(statusMessage);
        }
        model.addAttribute("tasks", tasks);
        model.addAttribute("statusMessages", statusMessages);
        return "task/task-list";
    }

    @GetMapping("tasks/priority/{priority}")
    public String findAllByPriority(@PathVariable String priority, Model model) {
        List<Task> tasks = taskService.findAllByPriority(Priority.valueOf(priority.toUpperCase()));
        List<String> priorityMessages = new ArrayList<>();
        for (Task task : tasks) {
            String priorityMessage = messageSource.getMessage("priority." + task.getPriority().name(), null, Locale.ENGLISH);
            priorityMessages.add(priorityMessage);
        }
        model.addAttribute("tasks", tasks);
        model.addAttribute("priorityMessages", priorityMessages);
        return "task/task-list";
    }

    @GetMapping("tasks/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Task> taskOpt = taskService.findById(id);
        if (taskOpt.isPresent()) {
            String statusMessage = messageSource.getMessage("status." + taskOpt.get().getStatus().name(), null, Locale.ENGLISH);
            model.addAttribute("task", taskOpt.get());
            model.addAttribute("statusMessage", statusMessage);
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
