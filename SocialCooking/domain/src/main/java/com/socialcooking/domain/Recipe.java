package com.socialcooking.domain;

import javax.persistence.*;

@Entity
@Table(name = "recipe")
@NamedQueries({
        @NamedQuery(name = "Recipe.findAll", query = "select r from Recipe r"),
        @NamedQuery(name = "Recipe.findById", query = "select r from Recipe r where r.name = :name")})
public class Recipe {

    @Id
    @Column(name = "recipe_name")
    private String name;

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="name_section")
    private Section section;

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="user_login")
    private User user;

    @Column(name = "photo_path")
    private String photo;

    @Column(name = "description")
    private String description;

    //accepted by manager
    @Column(name = "accepted")
    private boolean accepted;

    @Column(name = "positive_marks")
    private Integer countOfPositiveMarks;

    @Column(name = "negative_marks")
    private Integer countOfNegativeMarks;

    public Recipe() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Integer getCountOfPositiveMarks() {
        return countOfPositiveMarks;
    }

    public void setCountOfPositiveMarks(Integer countOfPositiveMarks) {
        this.countOfPositiveMarks = countOfPositiveMarks;
    }

    public Integer getCountOfNegativeMarks() {
        return countOfNegativeMarks;
    }

    public void setCountOfNegativeMarks(Integer countOfNegativeMarks) {
        this.countOfNegativeMarks = countOfNegativeMarks;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        if (photo != null ? !photo.equals(recipe.photo) : recipe.photo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (accepted ? 1 : 0);
        result = 31 * result + (countOfPositiveMarks != null ? countOfPositiveMarks.hashCode() : 0);
        result = 31 * result + (countOfNegativeMarks != null ? countOfNegativeMarks.hashCode() : 0);
        return result;
    }
}
