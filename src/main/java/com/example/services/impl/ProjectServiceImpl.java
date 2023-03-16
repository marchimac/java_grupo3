package com.example.services.impl;

import com.example.entities.Project;
import com.example.entities.Task;
import com.example.repositories.ProjectRepository;
import com.example.services.ProjectService;
import com.example.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final TaskService taskService;
    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> findByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public void saveAll(List<Project> projects) {
        projectRepository.saveAll(projects);
    }

    @Override
    public List<Project> findAllByCompanyId(Long id) {
        return projectRepository.findAllByCompanyId(id);
    }

    @Override
    public List<Project> findAllByCustomerId(Long id) {
        return projectRepository.findAllByCustomerId(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteById(Long id) {

        List<Task> tasks = taskService.findAllByProjectId(id);
        for (Task task : tasks) {
            task.setProject(null);
        }
        taskService.saveAll(tasks);

        projectRepository.deleteById(id);
    }
}