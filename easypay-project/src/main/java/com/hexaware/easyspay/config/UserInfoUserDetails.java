package com.hexaware.easyspay.config;

/*
 * Implements UserDetails interface to provide user information for authentication and authorization.
 * Maps roles from a comma-separated string to a list of GrantedAuthority objects.
 * Used to integrate user data with Spring Security's authentication mechanism.
 * 
 * @author Kariyappa D C,nihar
 * @date 26 November 2024
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.easyspay.entities.User;


public class UserInfoUserDetails implements UserDetails {


    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

    public UserInfoUserDetails(User userInfo) {
        name=userInfo.getUserName();
        password=userInfo.getPassword();
        authorities= Arrays.stream(userInfo.getRoleName().split(","))
                .map(SimpleGrantedAuthority::new) // .map(str -> new SimpleGrantedAuthority(str))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
