package com.example.services.impl;

import com.example.entities.Address;
import com.example.repositories.AddressRepository;
import com.example.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAllByCompanyId(Long id) {
        return addressRepository.findAllByCompanyId(id);
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void saveAll(List<Address> addresses) {
        addressRepository.saveAll(addresses);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findAllByEmployeeId(Long id) {
        return addressRepository.findAllByEmployeeId(id);
    }

}