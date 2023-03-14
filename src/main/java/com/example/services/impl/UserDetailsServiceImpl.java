package com.example.services.impl;

import com.example.entities.UserEntity;
import com.example.repositories.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserEntityRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userOpt = userRepo.findByEmail(email);
        if(userOpt.isPresent())
            return userOpt.get();
        else
            throw new UsernameNotFoundException(email + "not found");
    }
}
