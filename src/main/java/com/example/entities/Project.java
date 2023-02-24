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


    @ManyToOne // owner // selector3 simple
    private Company company;

    @ManyToOne // owner // selector4 simple
    private Customer customer; // customer_id

    @ManyToMany(mappedBy = "projects") // no owner, se guarda desde el otro lado, formulario de employee
    private List<Employee> employees = new ArrayList<>();
//
    @OneToMany(mappedBy = "project")
    private Set<Task> tasks = new HashSet<>();



}
