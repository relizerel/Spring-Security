package com.spring.dao;

import com.spring.model.User;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface UserDao {
    User getUser(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> listUsers();
    User getUserByLogin(String login);
}

