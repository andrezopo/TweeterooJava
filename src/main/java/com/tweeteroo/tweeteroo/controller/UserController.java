package com.tweeteroo.tweeteroo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.tweeteroo.dto.UserDTO;
import com.tweeteroo.tweeteroo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sign-up")
public class UserController {

    @Autowired
    private UserService service;
    
    @PostMapping
    public void signUp(@RequestBody @Valid UserDTO req) {
        service.signUp(req);
    }

}
