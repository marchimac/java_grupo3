package com.example.repositories;

import com.example.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByCompanyId(Long id);
    List<Address> findAllByEmployeeId(Long id);
}
