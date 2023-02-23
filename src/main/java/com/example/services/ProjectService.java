package com.example.services;


import com.example.entities.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findAll();
    Optional<Project> findById(Long id);

    void saveAll(List<Project> projects);

    List<Project> findAllByCompanyId(Long id);
    void deleteById(Long id);
}
