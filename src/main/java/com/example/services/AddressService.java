package com.example.services;

import com.example.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> findAll ();
    Optional<Address> findById(Long id);

    void deleteById(Long id);
}
