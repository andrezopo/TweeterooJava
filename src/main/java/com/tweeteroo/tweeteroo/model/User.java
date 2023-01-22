package com.tweeteroo.tweeteroo.model;

import java.util.ArrayList;
import java.util.Collection;

import com.tweeteroo.tweeteroo.dto.UserDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @Column(length = 50, nullable = false, unique = true)
    @Id
    private String username;


    @Column(length = 300, nullable = false)
    private String avatarUrl;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true )
    private Collection<Tweet> tweets = new ArrayList<>() {
        
    };
}
