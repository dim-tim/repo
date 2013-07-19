package com.socialcooking.repository;

import com.socialcooking.domain.Comment;

import java.util.List;

/**
 * @author Mikalai Kisel
 */
public interface CommentRepository {

    public Comment findById(Long id);

    public List<Comment> findAll();

    public Comment save(Comment comment);

    public Comment update(Comment comment);

    public void delete(Comment comment);
}
