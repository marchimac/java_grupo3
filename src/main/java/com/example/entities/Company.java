package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String slogan;

    @Column(unique = true)
    private String url;

    @Column(unique = true)
    private String linkedIn;

    @Column(unique = true)
    private String twitter;

    @Column(unique = true)
    private String cif;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @ToString.Exclude
    private Address address;

    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    private Set<Project> projects = new HashSet<>();
}
