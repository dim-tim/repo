package com.socialcooking.domain;

import javax.persistence.*;

@Entity
@Table(name = "recipe")
@NamedQueries({
        @NamedQuery(name = "Recipe.findAll", query = "select r from Recipe r"),
        @NamedQuery(name = "Recipe.findById", query = "select r from Recipe r where r.name = :name")})
public class Recipe {

    private String name;
    private byte [] photo;
    private String description;
    //accepted by manager
    private boolean accepted;
    private Double mark;

    @Id
    @Column(name = "recipe_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "mark")
    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    //it's for lazy download of pictures
    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "photo")
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Column(name = "accepted")
    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}
