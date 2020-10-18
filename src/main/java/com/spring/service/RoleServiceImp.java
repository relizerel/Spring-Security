package com.spring.service;

import com.spring.dao.RoleDao;
import com.spring.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImp implements RoleService {

    private final RoleDao roleDAO;

    public RoleServiceImp(RoleDao roleDAO) {
        this.roleDAO = roleDAO;
    }

    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }

}
