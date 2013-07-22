package com.socialcooking.repository;

import com.socialcooking.domain.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mikalai Kisel
 */

@Service("CommentRepository")
@Repository
@Transactional
public class CommentRepositoryImpl extends GenericRepositoryImpl<Comment, Long> implements CommentRepository{

    private Logger log = LoggerFactory.getLogger(CommentRepository.class);


}
