package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cif;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    @ToString.Exclude
    private Address address;

    @OneToMany(mappedBy = "customer") // no owner
    @ToString.Exclude
    private Set<Project> projects = new HashSet<>(); //columna customer_id en project


    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (!(o instanceof Customer customer)) return false;
        return getId().equals(customer.getId()) && getCif().equals(customer.getCif());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCif());
    }
}
