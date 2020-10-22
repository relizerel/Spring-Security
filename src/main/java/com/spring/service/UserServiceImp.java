package com.spring.service;


import com.spring.dao.UserDao;
import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserDetailsService, UserService{

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserDao userDao;

    @Autowired
    private UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
