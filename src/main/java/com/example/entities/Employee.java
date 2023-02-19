package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    @OneToOne
    @JoinColumn(unique = true)
    private Address address;
    private String position;
    private LocalDate birth;
    private LocalDate contracting;
    private LocalDate dismissal;
}
