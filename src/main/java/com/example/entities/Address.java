package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long State;
    private Long City;
    private Long PostalCode;
    private Long Address;
    private Long Address2;
    private Long Number;
    private Long Ladder;
    private Long Plant;
    private Long Door;

}
