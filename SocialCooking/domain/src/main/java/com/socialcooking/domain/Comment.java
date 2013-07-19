package com.socialcooking.domain;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@NamedQueries({
        @NamedQuery(name = "Comment.findAll", query = "select c from Comment c"),
        @NamedQuery(name = "Comment.findById", query = "select c from Comment c where c.id = :id")})
public class Comment {

    private Long id;
    private String text;

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
}
