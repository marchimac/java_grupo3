package com.example.services;

import com.example.entities.Task;
import com.example.entities.enums.Priority;
import com.example.entities.enums.Status;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    List<Task> findByName(String name);
    List<Task> findAllByStatus(Status status);
    List<Task> findAllByPriority(Priority priority);
    Task save(Task task);
    void deleteById(Long id);
    List<Task> findAllByEmployeeId(Long id);
    void saveAll(List<Task> tasks);
    List<Task> findAllByProjectId(Long id);
    Task getTaskById(Long id);

}
