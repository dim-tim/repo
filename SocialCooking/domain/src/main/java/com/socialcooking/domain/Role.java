package com.socialcooking.domain;

import javax.persistence.*;

@Entity
@Table(name = "role")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "select r from Role r"),
        @NamedQuery(name = "Role.findById", query = "select r from Role r where r.roleName = :name")})
public class Role {

    private String roleName;
    private String description;

    @Id
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
