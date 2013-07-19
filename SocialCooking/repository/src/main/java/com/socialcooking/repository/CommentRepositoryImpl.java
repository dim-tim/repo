package com.socialcooking.repository;

import com.socialcooking.domain.Comment;
import com.socialcooking.domain.Section;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Mikalai Kisel
 */

@Service("CommentRepository")
@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository{

    @PersistenceContext
    private EntityManager em;

    private Logger log = LoggerFactory.getLogger(CommentRepository.class);

    @Override
    public Comment findById(Long id) {
        log.info("Find by id "+id);
        TypedQuery<Comment> query = em.createNamedQuery("Comment.findById", Comment.class);
        query.setParameter("id", id);
        Comment comment = query.getSingleResult();
        return comment;
    }

    @Override
    public List<Comment> findAll() {
        log.info("Find all");
        List<Comment> comments = em.createNamedQuery("Comment.findAll", Comment.class).getResultList();
        return comments;
    }

    @Override
    public Comment save(Comment comment) {
        log.info("Save new comment");
        em.persist(comment);
        return comment;
    }

    @Override
    public Comment update(Comment comment) {
        log.info("Update comment");
        em.merge(comment);
        return comment;
    }

    @Override
    public void delete(Comment comment) {
        log.info("Delete comment");
        Comment mergedComment = em.merge(comment);
        em.remove(comment);
    }
}
