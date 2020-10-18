package com.spring.service;

import com.spring.model.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> listUsers();
    User getUserById(String login);
}
