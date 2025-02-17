package com.gcu.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.entity.UserEntity;
import com.gcu.repository.UserRepository;

@Service
public class UserBusinessService implements UserDetailsService {

    private final UserRepository repository;

    public UserBusinessService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Attempting to find user: " + username);

        UserEntity user = repository.findByUsername(username);
        if (user == null) {
            System.out.println("User not found in the database!");
            throw new UsernameNotFoundException("User not found!");
        }

        System.out.println("User found: " + user.getUsername());

        return User.withUsername(user.getUsername())
            .password("{noop}" + user.getPassword()) 
            .roles("USER")
            .build();
    }

    // Save user
    public void saveUser(UserEntity user) {
        repository.save(user); // Save password as plain text
    }
}