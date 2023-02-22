package com.example.controllers;

import com.example.entities.Address;
import com.example.entities.Customer;
import com.example.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("customers/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Customer> customerOpt = customerService.findById(id);
        if (customerOpt.isPresent())
            model.addAttribute("customer", customerOpt.get());
        else
            model.addAttribute("error", "Customer not found");

        return "customer/customer-detail";
    }

    @GetMapping("customers/create")
    public String createForm(Model model) {
        Customer customer = new Customer();
        customer.setAddress(new Address()); // Objeto Address dentro de objeto Customer para que se guarde también en BD
        model.addAttribute("customer", customer);
        return "customer/customer-form";
    }

    @GetMapping("customers/{id}/edit")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Customer> customerOpt = customerService.findById(id);
        if (customerOpt.isPresent())
            model.addAttribute("customer", customerOpt.get());
        else
            model.addAttribute("error", "Customer not found");

        return "customer/customer-form";
    }

    @PostMapping("customers")
    public String saveForm(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("customers/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }
}




