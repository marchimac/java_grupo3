package com.example.services.impl;

import com.example.entities.Task;
import com.example.entities.enums.Priority;
import com.example.entities.enums.Status;
import com.example.repositories.TaskRepository;
import com.example.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;


    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    public List<Task> findAllByStatus(Status status) {
        return taskRepository.findAllByStatus(status);
    }

    @Override
    public List<Task> findAllByPriority(Priority priority) {
        return taskRepository.findAllByPriority(priority);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAllByEmployeeId(Long id) {
        return taskRepository.findAllByEmployeeId(id);
    }

    @Override
    public void saveAll(List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

    @Override
    public List<Task> findAllByProjectId(Long id) {
        return taskRepository.findAllByProjectId(id);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.getTaskById(id);
    }
}