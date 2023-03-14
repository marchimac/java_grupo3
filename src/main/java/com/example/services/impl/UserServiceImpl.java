package com.example.services.impl;

import com.example.entities.UserEntity;
import com.example.repositories.UserEntityRepository;
import com.example.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userRepo;

    @Override
    public boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepo.save(user);
    }
}