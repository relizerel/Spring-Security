package com.spring.dao;

import com.spring.model.User;
import org.codehaus.plexus.component.annotations.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

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
    public User getUserByUsername(String username) {
        return (User) entityManger.createQuery("select u from User u where u.username = :username").setParameter("username", username).getSingleResult();
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