package com.example.repositories;

import com.example.entities.Address;
import com.example.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
