package com.govind.SpringSecurityExample.service;

import com.govind.SpringSecurityExample.model.UserPrincipal;
import com.govind.SpringSecurityExample.model.Users;
import com.govind.SpringSecurityExample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = userRepo.findByUsername(username);
        System.out.println(user);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found.");
        }
        return new UserPrincipal(user);
    }
}
