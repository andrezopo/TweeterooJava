package com.tweeteroo.tweeteroo.model;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.annotations.NaturalId;

import com.tweeteroo.tweeteroo.dto.PersonDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "persons")
public class Person {
    
    public Person(PersonDTO data){
        this.username = data.username();
        this.avatarUrl = data.avatar();
    }

    public Person(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true, name = "username")
    @NaturalId
    private String username;


    @Column(length = 300, nullable = false, name = "avatar_url")
    private String avatarUrl;
}
