package com.socialcooking.service;

import com.socialcooking.domain.Comment;
import com.socialcooking.repository.api.CommentRepository;
import com.socialcooking.service.api.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("commentService")
@Repository
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment saveOrUpdate(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public long countComment() {
        return commentRepository.count();
    }
}
