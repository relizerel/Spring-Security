package com.spring.service;


import com.spring.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    List<User> listUsers();
    void deleteUser(User User);
    void updateUser(User user);
    User getUserById(Long id);
}
