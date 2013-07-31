package com.socialcooking.domain;


import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class User extends DomainObject {

    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;

    private String photoPath;
    private LocalDateTime birthday;
    private GenderType gender;
    private Integer telephone;
    private String country;
    private String city;
    private String address;
    private String about;
    private Integer countOfPositiveMarks;
    private Integer countOfNegativeMarks;

    private LocalDateTime dateRegistration;

    //for many to many mapping
    private Set<Role> roles = new HashSet<Role>();
    private Set<Comment> comments = new HashSet<Comment>();
    private Set<Recipe> recipes = new HashSet<Recipe>();

    @Column(name = "user_login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "birth_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    @Column(name = "telephone")
    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "about")
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Column(name = "registration_date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    public LocalDateTime getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDateTime dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    @Column(name = "negative_marks")
    public Integer getCountOfNegativeMarks() {
        return countOfNegativeMarks;
    }


    public void setCountOfNegativeMarks(Integer countOfNegativeMarks) {
        this.countOfNegativeMarks = countOfNegativeMarks;
    }

    @Column(name = "positive_marks")
    public Integer getCountOfPositiveMarks() {
        return countOfPositiveMarks;
    }

    public void setCountOfPositiveMarks(Integer countOfPositiveMarks) {
        this.countOfPositiveMarks = countOfPositiveMarks;
    }

    @Column(name = "photo_path")
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "app_user_has_role",
            joinColumns = @JoinColumn(name = "id_app_user_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_role_fk"))
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
