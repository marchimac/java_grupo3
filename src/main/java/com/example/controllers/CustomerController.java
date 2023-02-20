package com.example.controllers;

import com.example.entities.Customer;
import com.example.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("customers")
    public String findAll(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customer/customer-list";
    }

    @GetMapping("customers/{id}") // http://localhost:8080/customers/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Customer> customerOpt = customerService.findById(id);
        if (customerOpt.isPresent())
            model.addAttribute("customer", customerOpt.get());
        else
            model.addAttribute("error", "Customer not found");

        return "customer/customer-detail";
    }


}




