package com.socialcooking.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {


    private Long id;
    private String roleName;
    private String description;

    private Set<User> users = new HashSet<User>();

    public Role() {

    }

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
    }

    public Role(Long id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    public Long getId_role() {
        return id;
    }

    public void setId_role(Long id) {
        this.id = id;
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
            inverseJoinColumns = @JoinColumn(name = "id_app_user_fk"))
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id_role=" + id +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (description != null ? !description.equals(role.description) : role.description != null) return false;
        if (id != null ? !id.equals(role.id) : role.id != null) return false;
        if (roleName != null ? !roleName.equals(role.roleName) : role.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
