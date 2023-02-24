package com.example.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
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

//    @ManyToOne
//    private Customer customer;
//
//    @OneToMany
//    private Employee employee;
//
//    @OneToMany
//    private Task task;

}
