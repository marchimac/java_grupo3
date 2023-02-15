package com.example.services;

import com.example.entities.Customer;
import com.example.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepo;

    @Override
    public List<Customer> findAll() {
        log.info("findAll");
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        log.info("findById {}", id);
        if (id == null || id <= 0)
            return Optional.empty();

        return customerRepo.findById(id);
    }

    @Override
    public Optional<Customer> findByName(String name) {
        log.info("findByName {}", name);
        return customerRepo.findByName(name);
    }

    @Override
    public Optional<Customer> findByCif(String cif) {
        log.info("findByCif {}", cif);
        return customerRepo.findByCif(cif);
    }

    @Override
    public Optional<Customer> findByPhone(String phone) {
        log.info("findByPhone {}", phone);
        return customerRepo.findByPhone(phone);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        log.info("findByEmail {}", email);
        return customerRepo.findByEmail(email);
    }

    @Override
    public Customer save(Customer customer) {
        log.info("save customer {}", customer);

        try {
            this.customerRepo.save(customer);
        } catch (Exception e) {
            log.error("Error saving customer {}", customer);
        }
        return customer;
    }

    @Override
    public void deleteById(Long id) {

        log.info("deleteById {}", id);
        try {
            this.customerRepo.deleteById(id);
        } catch (Exception e) {
            log.error("Error deleting customer {}", id);
        }
    }
}
