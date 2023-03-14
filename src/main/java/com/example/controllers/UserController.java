package com.example.controllers;

import com.example.entities.UserEntity;
import com.example.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class UserController {

    public static final int MIN_LENGTH_PASSWORD = 4;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("user/registration")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "user/user-register";
    }

    @PostMapping("user/registration")
    public String saveRegistrationForm(@ModelAttribute UserEntity user, Model model) {

        // comprobar si ya existe por username
        if (userService.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "username not available");
            model.addAttribute("user", new UserEntity());
            return "user/user-register";
        }

        // comprobar si ya existe por email
        if (userService.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "email not available");
            model.addAttribute("user", new UserEntity());
            return "user/user-register";
        }

        // comprobar contraseña
        if(user.getPassword().length() < MIN_LENGTH_PASSWORD) {
            model.addAttribute("error", "password length too small");
            model.addAttribute("user", new UserEntity());
            return "user/user-register";
        }

        // Codificar password
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);

        // si está username y email libres entonces se guarda
        userService.save(user);
        return "redirect:/login";
    }
}