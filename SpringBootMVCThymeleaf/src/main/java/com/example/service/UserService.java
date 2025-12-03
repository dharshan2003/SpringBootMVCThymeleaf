package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository usersRepository;

    public String registerUser(User user) {
        if (usersRepository.userExists(user.getUsername())) {
            return "Username already exists!";
        }
        usersRepository.saveUser(user);
        return "User registered successfully!";
    }
}
