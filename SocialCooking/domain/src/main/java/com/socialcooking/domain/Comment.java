package com.socialcooking.domain;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "app_comment")
public class Comment {

    private Long id;
    private String text;
    private LocalDateTime date;
    private Integer countOfPositiveMarks;
    private Integer countOfNegativeMarks;


    public Comment() {

    }

    public Comment(Long id, String text, LocalDateTime date, Integer countOfPositiveMarks, Integer countOfNegativeMarks) {
        this.id = id;
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


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "content")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "date")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (countOfNegativeMarks != null ? !countOfNegativeMarks.equals(comment.countOfNegativeMarks) : comment.countOfNegativeMarks != null)
            return false;
        if (countOfPositiveMarks != null ? !countOfPositiveMarks.equals(comment.countOfPositiveMarks) : comment.countOfPositiveMarks != null)
            return false;
        if (date != null ? !date.equals(comment.date) : comment.date != null) return false;
        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (text != null ? !text.equals(comment.text) : comment.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (countOfPositiveMarks != null ? countOfPositiveMarks.hashCode() : 0);
        result = 31 * result + (countOfNegativeMarks != null ? countOfNegativeMarks.hashCode() : 0);
        return result;
    }
}
