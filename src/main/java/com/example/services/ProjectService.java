package com.example.services;


import com.example.entities.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findAll();
    Optional<Project> findById(Long id);
    List<Project> findByName(String name);
    List<Project> findAllByCompanyId(Long id);
    List<Project> findAllByCustomerId(Long id);
    Project save(Project project);
    void saveAll(List<Project> projects);
    void deleteById(Long id);
}