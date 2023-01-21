package com.tweeteroo.tweeteroo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.tweeteroo.tweeteroo.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class User {
    
    public User(UserDTO data){
        this.username = data.username();
        this.avatarUrl = data.avatar();
    }

    public User(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String username;


    @Column(length = 300, nullable = false)
    private String avatarUrl;

    @OneToMany
    private Collection<Tweet> tweets = new ArrayList<>() {
        
    };
}
