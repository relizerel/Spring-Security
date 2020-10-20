package com.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "role")
    private String role;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",
            joinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
    )
    private List<User> userRoles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<User> userRoles) {
        this.userRoles = userRoles;
    }

}
