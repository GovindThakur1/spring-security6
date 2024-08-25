package com.govind.SpringSecurityExample.service;

import com.govind.SpringSecurityExample.model.Users;
import com.govind.SpringSecurityExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }





}
