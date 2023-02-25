package com.example.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

import lombok.*;
import org.hibernate.Hibernate;

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

    @OneToMany(mappedBy = "project")
    @ToString.Exclude
    private Set<Task> tasks = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || Hibernate.getClass(this)!=Hibernate.getClass(o)) return false;
        Project project = (Project) o;
        return id!=null && Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
