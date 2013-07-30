package com.socialcooking.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe extends DomainObject {

    private String name;
    private String photoPath;
    private String description;
    //accepted by manager
    private boolean accepted;
    private Integer countOfPositiveMarks;
    private Integer countOfNegativeMarks;

    private Set<Comment> comments = new HashSet<Comment>();
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();
    private Set<Delivery> deliveries = new HashSet<Delivery>();

    private User user;
    private Section section;

    public Recipe() {

    }

    public Recipe(Long id, String name, String description, String photoPath, boolean accepted, Integer countOfPositiveMarks, Integer countOfNegativeMarks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photoPath = photoPath;
        this.accepted = accepted;
        this.countOfPositiveMarks = countOfPositiveMarks;
        this.countOfNegativeMarks = countOfNegativeMarks;
    }

    public Recipe(String name, String photoPath, String description, boolean accepted, Integer countOfPositiveMarks, Integer countOfNegativeMarks) {
        this.name = name;
        this.photoPath = photoPath;
        this.description = description;
        this.accepted = accepted;
        this.countOfPositiveMarks = countOfPositiveMarks;
        this.countOfNegativeMarks = countOfNegativeMarks;
    }

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

    @Column(name = "photo_path")
    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Column(name = "positive_marks")
    public Integer getCountOfPositiveMarks() {
        return countOfPositiveMarks;
    }

    public void setCountOfPositiveMarks(Integer countOfPositiveMarks) {
        this.countOfPositiveMarks = countOfPositiveMarks;
    }

    @Column(name = "negative_marks")
    public Integer getCountOfNegativeMarks() {
        return countOfNegativeMarks;
    }

    public void setCountOfNegativeMarks(Integer countOfNegativeMarks) {
        this.countOfNegativeMarks = countOfNegativeMarks;
    }

    @Column(name = "accepted")
    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="id_app_user_fk")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="id_section_fk")
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "delivery_has_recipe",
            joinColumns = @JoinColumn(name = "id_recipe_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_delivery_fk"))
    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (accepted != recipe.accepted) return false;
        if (countOfNegativeMarks != null ? !countOfNegativeMarks.equals(recipe.countOfNegativeMarks) : recipe.countOfNegativeMarks != null)
            return false;
        if (countOfPositiveMarks != null ? !countOfPositiveMarks.equals(recipe.countOfPositiveMarks) : recipe.countOfPositiveMarks != null)
            return false;
        if (description != null ? !description.equals(recipe.description) : recipe.description != null) return false;
        if (id != null ? !id.equals(recipe.id) : recipe.id != null) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        if (photoPath != null ? !photoPath.equals(recipe.photoPath) : recipe.photoPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (accepted ? 1 : 0);
        result = 31 * result + (countOfPositiveMarks != null ? countOfPositiveMarks.hashCode() : 0);
        result = 31 * result + (countOfNegativeMarks != null ? countOfNegativeMarks.hashCode() : 0);
        return result;
    }

}
