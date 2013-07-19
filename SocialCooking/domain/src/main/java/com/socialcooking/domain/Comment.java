package com.socialcooking.domain;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name = "app_comment")
@NamedQueries({
        @NamedQuery(name = "Comment.findAll", query = "select c from Comment c"),
        @NamedQuery(name = "Comment.findById", query = "select c from Comment c where c.id = :id")})
public class Comment {

    private Long id;
    private String text;
    private DateTime date;

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
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
//    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
//    @DateTimeFormat(iso = ISO.DATE)
    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }
}
