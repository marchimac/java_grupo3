package com.example.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true)
    private String name;
    private String description;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private Double totalCost;
    @ManyToOne
    private Company company;

    @ManyToOne
    private Customer customer;

    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private Set<Task> tasks = new HashSet<>();


    public Project(Object o, String project1, String webapp1, LocalDate of, LocalDate of1, double v, Company company1) {
    }
}
