package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @ToString.Exclude
    private Address address;
    private String position;
    private LocalDate birth;
    private LocalDate contracting;
    private LocalDate dismissal;

    @ManyToOne
    private Company company;

    @ManyToMany // owner
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
