package com.example.repositories;

import com.example.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    /*List<Project> findAllByCustomerId(Long id); // Listado de proyectos por cliente. Se puede usar en customer-detail.html llamando a esta consulta*/
}