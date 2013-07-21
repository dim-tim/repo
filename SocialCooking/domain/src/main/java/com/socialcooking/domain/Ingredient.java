package com.socialcooking.domain;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
@NamedQueries({
        @NamedQuery(name = "Ingredient.findAll", query = "select ing from Ingredient ing"),
        @NamedQuery(name = "Ingredient.findById", query = "select ing from Ingredient ing where ing.id = :id")})
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient")
    private Long id;

    @Column(name = "name_ingredient")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "quantity")
    private String quantity;

    public Ingredient() {

    }

    public Ingredient(Long id, String name, String comment, String quantity) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.quantity = quantity;
    }

    public Ingredient(String name, String comment, String quantity) {
        this.name = name;
        this.comment = comment;
        this.quantity = quantity;
    }

    public Long getId() {
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


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
