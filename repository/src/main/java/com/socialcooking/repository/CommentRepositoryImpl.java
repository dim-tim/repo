package com.socialcooking.repository;

import com.socialcooking.domain.Comment;
import com.socialcooking.repository.api.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CommentRepository")
@Repository
@Transactional
public class CommentRepositoryImpl extends GenericRepositoryImpl<Comment> implements CommentRepository {

    private Logger log = LoggerFactory.getLogger(CommentRepository.class);




}
