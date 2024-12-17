package com.hexaware.easyspay.service;

/**
 * Service for managing user operations, including user registration.
 * Encrypts the user's password before saving it to the database using PasswordEncoder.
 * 
 * Author: Kariyappa D C, Nihar
 * Date: 25 November 2024
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.entities.User;
import com.hexaware.easyspay.repository.IUserRepository;



@Service
public class UserService {
	
	@Autowired
    private IUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
	
	
	public String addUser(User userInfo) {  // user registration
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }

}
