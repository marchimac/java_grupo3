package com.example.services;

import com.example.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    List<Task> findByName(String name);
    Task save(Task task);
    void deleteById(Long id);
}