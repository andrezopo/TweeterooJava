package com.tweeteroo.tweeteroo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweeteroo.tweeteroo.dto.UserDTO;
import com.tweeteroo.tweeteroo.model.User;
import com.tweeteroo.tweeteroo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public void signUp(UserDTO user){
        repository.save(new User(user));
    }
}
