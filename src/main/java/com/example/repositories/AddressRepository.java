package com.example.repositories;

import com.example.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Project, Long> {
}
