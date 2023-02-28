package com.example.services.impl;

import com.example.entities.Company;
import com.example.entities.Project;
import com.example.entities.Task;
import com.example.repositories.CompanyRepository;
import com.example.repositories.ProjectRepository;
import com.example.repositories.TaskRepository;
import com.example.services.EmployeeService;
import com.example.services.ProjectService;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.Set;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final EmployeeService employeeService;
    private final CompanyRepository companyRepo;
    private final TaskRepository taskRepository;
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
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);

    }
}
