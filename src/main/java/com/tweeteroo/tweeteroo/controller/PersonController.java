package com.tweeteroo.tweeteroo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.tweeteroo.dto.PersonDTO;
import com.tweeteroo.tweeteroo.model.Person;
import com.tweeteroo.tweeteroo.service.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("")
public class PersonController {

    @Autowired
    private PersonService service;
    
    @PostMapping("/sign-up")
    public void signUp(@RequestBody @Valid PersonDTO req) {
        service.signUp(req);
    }

    @GetMapping("/users")
    public List<Person> findAll ( ){
        return service.listAll();
    }

}
