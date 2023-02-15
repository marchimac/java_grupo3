package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

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
    Long id;
    String name;
    @Column(unique = true)
    String cif;
    //Address address;
    String phone;
    String email;


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
