package com.spring.service;


import com.spring.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User getUser(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> listUsers();
    User getUserByUsername(String username);
    void createUser(User user);
}
