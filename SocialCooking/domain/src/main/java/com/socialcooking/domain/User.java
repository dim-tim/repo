package com.socialcooking.domain;


import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select u from User u"),
        @NamedQuery(name = "User.findById", query = "select u from User u where u.login = :login")})
public class User {

    @Id
    @Column(name = "user_login")
    private String login;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "app_user_has_role",
            joinColumns = @JoinColumn(name = "user_login"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    private Set<Role> roles = new HashSet<Role>();

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "birth_date")
    private LocalDateTime birthday;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Column(name = "telephone")
    private Integer telephone;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "about")
    private String about;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "registration_date")
    private DateTime dateRegistration;

    @Column(name = "photo")
    private String photoPath;

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public DateTime getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(DateTime dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (about != null ? !about.equals(user.about) : user.about != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        if (dateRegistration != null ? !dateRegistration.equals(user.dateRegistration) : user.dateRegistration != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (gender != user.gender) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (photoPath != null ? !photoPath.equals(user.photoPath) : user.photoPath != null) return false;
        if (rating != null ? !rating.equals(user.rating) : user.rating != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (telephone != null ? !telephone.equals(user.telephone) : user.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (dateRegistration != null ? dateRegistration.hashCode() : 0);
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        return result;
    }
}
