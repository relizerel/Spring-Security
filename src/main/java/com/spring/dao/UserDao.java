package com.spring.dao;

import com.spring.model.User;
import org.codehaus.plexus.component.annotations.Component;

import java.util.List;

@Component
public interface UserDao {
    User getUser(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    List<User> listUsers();
    User getUserByUsername(String username);
}