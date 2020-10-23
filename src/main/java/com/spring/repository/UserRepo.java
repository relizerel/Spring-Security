package com.spring.repository;

import com.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
    void deleteUser(User user);
}
