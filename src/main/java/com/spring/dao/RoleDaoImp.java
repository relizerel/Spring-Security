package com.spring.dao;

import com.spring.model.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Component
@Repository
public class RoleDaoImp implements RoleDao {

    private final EntityManager entityManager;

    public RoleDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Role getRole(int id) {
        return entityManager.find(Role.class, id);
    }
}
