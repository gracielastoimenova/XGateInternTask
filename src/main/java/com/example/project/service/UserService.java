package com.example.project.service;


import com.example.project.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

     UserDetails loadUserByEmail(String email);

     User saveUser(String name, String email, String password);

    User getCurrentUser();
}
