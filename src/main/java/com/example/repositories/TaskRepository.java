package com.example.repositories;

import com.example.entities.Task;
import com.example.entities.enums.Priority;
import com.example.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByName(String name);
    List<Task> findAllByEmployeeId(Long id);
    List<Task> findAllByStatus(Status status);
    List<Task> findAllByPriority(Priority priority);
    Task getTaskById(Long id);
}