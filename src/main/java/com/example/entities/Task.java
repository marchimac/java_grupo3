package com.example.entities;

import com.example.entities.enums.Priority;
import com.example.entities.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate dueDate;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Employee employee;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Priority priority;
}
