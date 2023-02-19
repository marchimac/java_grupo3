package com.example.controllers;

import com.example.entities.Customer;
import com.example.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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



}




