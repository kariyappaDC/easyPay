package com.hexaware.easyspay.config;

/*
 * Custom implementation of UserDetailsService to load user information from the database.
 * Retrieves user details by username and maps to a UserInfoUserDetails object.
 * Throws UsernameNotFoundException if the user is not found in the repository.
 * 
 * @author Kariyappa D C,nihar
 * @date November 2024
 */


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexaware.easyspay.entities.User;
import com.hexaware.easyspay.repository.IUserRepository;



@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = repository.findByUserName(username);
        
        return userInfo.map(UserInfoUserDetails::new) 
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}

