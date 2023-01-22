package com.tweeteroo.tweeteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.tweeteroo.model.Person;

public interface PersonRepository extends JpaRepository<Person, String> {
    
}
