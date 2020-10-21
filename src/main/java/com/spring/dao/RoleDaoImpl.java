package com.spring.dao;

import com.spring.model.UserRole;
import org.codehaus.plexus.component.annotations.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Component
@Repository
public class RoleDaoImpl implements RoleDao {

    private final EntityManager entityManager;

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public UserRole getRole(int id) {
        return entityManager.find(UserRole.class, id);
    }
}