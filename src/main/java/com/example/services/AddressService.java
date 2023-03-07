package com.example.services;

import com.example.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> findAll ();
    Optional<Address> findById(Long id);
    List<Address> findAllByCompanyId(Long id);
    Address save(Address address);
    void saveAll(List<Address> addresses);
    void deleteById(Long id);
    List<Address> findAllByEmployeeId(Long id);
}
