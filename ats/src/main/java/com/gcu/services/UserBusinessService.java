package com.gcu.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.entity.UserEntity;
import com.gcu.repository.UserRepository;

/*
 * Service class to handle user authentication
 * Downloads users from database
 */
@Service
public class UserBusinessService implements UserDetailsService {

    private final UserRepository repository;

    /*
     * Injects UserRepository
     * @param repository used to access data
     */

    public UserBusinessService(UserRepository repository) {
        this.repository = repository;
    }

    /*
     * loads username to authenticate
     * 
     * @param username
     * @return object of user details
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return User.withUsername(user.getUsername())
            .password(user.getPassword())  // Plain text password
            .roles("USER")
            .build();
    }
}
