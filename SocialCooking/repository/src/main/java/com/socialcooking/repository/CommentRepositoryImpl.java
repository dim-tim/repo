package com.socialcooking.repository;

import com.socialcooking.domain.Comment;
import com.socialcooking.repository.api.CommentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("CommentRepository")
@Repository
@Transactional
public class CommentRepositoryImpl extends GenericRepositoryImpl<Comment> implements CommentRepository {


    protected CommentRepositoryImpl() {
        super(Comment.class);
    }
}
