package com.socialcooking.repository.api;

import com.socialcooking.domain.Comment;

import java.util.List;

/**
 * @author Mikalai Kisel
 */
public interface CommentRepository extends IGenericRepository<Comment> {

    public Comment findById(Long id);

    public List<Comment> findAll();

    public Comment save(Comment comment);

    public Comment update(Comment comment);

    public void delete(Comment comment);
}
