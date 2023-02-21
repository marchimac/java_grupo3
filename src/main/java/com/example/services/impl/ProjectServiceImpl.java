package com.example.services.impl;

import com.example.entities.Project;
import com.example.repositories.ProjectRepository;
import com.example.services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public void saveAll(List<Project> projects) {
        projectRepository.saveAll(projects);
    }

    @Override
    public List<Project> findAllByCompanyId(Long id) {
        return projectRepository.findAllByCompanyId(id);
    }
}
