package com.example.controllers;

import com.example.entities.Address;
import com.example.entities.Customer;
import com.example.services.CustomerService;
import com.example.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class CustomerController {

    private final CustomerService customerService;
    private final FileService fileService;

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
    public String saveForm(Model model, @ModelAttribute Customer customer, @RequestParam("file") MultipartFile file) {
        if (file == null || file.isEmpty()) {
            customerService.save(customer);
            return "redirect:/customers";
        }

        try {
            String fileName = fileService.storeInFileSystem(file);
            customer.setImageUrl(fileName); // string
            customerService.save(customer);
            return "redirect:/customers"; // redirección a controlador findAll
        } catch (Exception e) {
            model.addAttribute("error", "Failed to save image");
            model.addAttribute("customers", customerService.findAll());
            return "customer/customer-list";
        }
    }

    @GetMapping("customers/{id}/delete")
    public String deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }
}


