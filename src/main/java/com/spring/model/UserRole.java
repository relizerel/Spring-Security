package com.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user_roles")
@Data
@Transient
public class UserRole implements GrantedAuthority {
    @Id
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public UserRole() {
    }

    public UserRole(Long id) {
        this.id = id;
    }

    public UserRole(Long id, String name) {
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
