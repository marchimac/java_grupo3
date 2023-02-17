package com.example.controllers;

import com.example.entities.Address;
import com.example.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class AddressController {
    private final AddressService addressService;

    @GetMapping("address")
    public String findAll(Model model) {
        List<Address> address = addressService.findAll();
        model.addAttribute("address", address);
        return "addess-list";
    }
}
