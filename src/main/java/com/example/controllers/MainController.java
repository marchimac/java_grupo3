package com.example.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String main() {
        return "main-page/main";
    }
}