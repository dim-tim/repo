package com.socialcooking.service;

import com.socialcooking.domain.Comment;
import com.socialcooking.repository.api.CommentRepository;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.service.api.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("commentService")
@Transactional
public class CommentServiceImpl extends GenericServiceImpl<Comment> implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    protected GenericRepository<Comment> getRepository() {
        return commentRepository;
    }

}
