package com.socialcooking.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {


    private Long id_role;
    private String roleName;
    private String description;

    private Set<User> users = new HashSet<User>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "app_user_has_role",
            joinColumns = @JoinColumn(name = "id_role_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_user_fk"))
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id_role=" + id_role +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
