package com.spring.service;


import com.spring.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(Long id);
    void deleteUser(Long id);
    void updateUser(User user);
    List<User> listUsers();
    void createUser(User user);
}
