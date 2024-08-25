package com.govind.SpringSecurityExample.controller;

import com.govind.SpringSecurityExample.model.Users;
import com.govind.SpringSecurityExample.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users/register")
    public ResponseEntity<Users> register(@RequestBody Users user) {
        return new ResponseEntity<>(usersService.register(user), HttpStatus.CREATED);
    }


}
