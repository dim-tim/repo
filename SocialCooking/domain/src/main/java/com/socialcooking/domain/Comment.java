package com.socialcooking.domain;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "app_comment")
@NamedQueries({
        @NamedQuery(name = "Comment.findAll", query = "select c from Comment c"),
        @NamedQuery(name = "Comment.findById", query = "select c from Comment c where c.id = :id")})
public class Comment extends DomainObject{

    @ManyToOne(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    @JoinColumn(name="ip_app_user_fk")
    private User user;

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="id_recipe_fk")
    private Recipe recipe;

    @Column(name = "content")
    private String text;

    @Column(name = "date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    private LocalDateTime date;

    @Column(name = "positive_marks")
    private Integer countOfPositiveMarks;

    @Column(name = "negative_marks")
    private Integer countOfNegativeMarks;

    public Comment() {

    }

    public Comment(Long id, String text, LocalDateTime date, Integer countOfPositiveMarks, Integer countOfNegativeMarks) {
        setId(id);
        this.text = text;
        this.date = date;
        this.countOfPositiveMarks = countOfPositiveMarks;
        this.countOfNegativeMarks = countOfNegativeMarks;
    }

    public Comment(String text, LocalDateTime date, Integer countOfPositiveMarks, Integer countOfNegativeMarks) {
        this.text = text;
        this.date = date;
        this.countOfPositiveMarks = countOfPositiveMarks;
        this.countOfNegativeMarks = countOfNegativeMarks;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Comment comment = (Comment) o;

        if (countOfNegativeMarks != null ? !countOfNegativeMarks.equals(comment.countOfNegativeMarks) : comment.countOfNegativeMarks != null)
            return false;
        if (countOfPositiveMarks != null ? !countOfPositiveMarks.equals(comment.countOfPositiveMarks) : comment.countOfPositiveMarks != null)
            return false;
        if (date != null ? !date.equals(comment.date) : comment.date != null) return false;
        if (recipe != null ? !recipe.equals(comment.recipe) : comment.recipe != null) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;
        if (user != null ? !user.equals(comment.user) : comment.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (recipe != null ? recipe.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (countOfPositiveMarks != null ? countOfPositiveMarks.hashCode() : 0);
        result = 31 * result + (countOfNegativeMarks != null ? countOfNegativeMarks.hashCode() : 0);
        return result;
    }
}
