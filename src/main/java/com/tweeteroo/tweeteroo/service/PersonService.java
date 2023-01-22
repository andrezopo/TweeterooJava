package com.tweeteroo.tweeteroo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweeteroo.tweeteroo.dto.PersonDTO;
import com.tweeteroo.tweeteroo.model.Person;
import com.tweeteroo.tweeteroo.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository repository;

    public void signUp(PersonDTO user){
        repository.save(new Person(user));
    }

    public List<Person> listAll() {
        return repository.findAll();
    }
}
