package com.socialcooking.domain;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
@NamedQueries({
        @NamedQuery(name = "Ingredient.findAll", query = "select ing from Ingredient ing"),
        @NamedQuery(name = "Ingredient.findById", query = "select ing from Ingredient ing where ing.id = :id")})
public class Ingredient {

    private Long id;
    private String name;
    private String comment;
    private String quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name_ingredient")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name = "quantity")
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
