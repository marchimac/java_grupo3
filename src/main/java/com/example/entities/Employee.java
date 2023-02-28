package com.example.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String dni;
    private String password;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String position;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate contracting;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dismissal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @ToString.Exclude
    private Address address;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    @ToString.Exclude
    private Set<Project> projects = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    @ToString.Exclude
    private Set<Task> tasks = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Employee employee)) return false;
        return getId().equals(employee.getId()) && getDni().equals(employee.getDni()) && getEmail().equals(employee.getEmail()) && getPhone().equals(employee.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDni(), getEmail(), getPhone());
    }
}
