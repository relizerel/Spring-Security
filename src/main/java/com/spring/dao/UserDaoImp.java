package com.spring.dao;

import com.spring.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager entityManger;


    @Override
    public User getUser(Long id) {
        return entityManger.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return (List<User>) entityManger.createQuery("SELECT users FROM User users").getResultList();
    }

    @Override
    public User getUserByLogin(String login) {
        List<User> userList;
        Query query = entityManger.createQuery("select u from User u where u.login = :login");
        query.setParameter("login", login);
        userList = query.getResultList();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;
    }

    @Override
    public void saveUser(User user) {
        entityManger.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManger.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        if (entityManger.contains(user)) {
            entityManger.remove(user);
        } else {
            entityManger.remove(entityManger.merge(user));
        }
    }
}
