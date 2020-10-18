package com.spring.dao;

import com.spring.model.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;


    public Role getRole(int id) {
        return entityManager.find(Role.class, id);
    }
}
