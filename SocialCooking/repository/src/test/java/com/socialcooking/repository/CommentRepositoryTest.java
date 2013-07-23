package com.socialcooking.repository;

import com.socialcooking.domain.Comment;
import org.joda.time.LocalDateTime;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * @author Mikalai Kisel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/datasource-test.xml")
//May be H2 or MYSQL
@ActiveProfiles("H2")
public class CommentRepositoryTest {

    @Autowired
    private CommentRepositoryImpl commentRepository;

    @Test
    public void findAllTest() {
        commentRepository.setPersistentClass(Comment.class);
        List<Comment> comments = commentRepository.findAll();
        assertNotNull(comments);
    }

    @Test
    public void findByIdTest() {
        commentRepository.setPersistentClass(Comment.class);

        Comment expectedComment = new Comment(1L, "Это первое сообщение", new LocalDateTime("2013-07-19T05:25:00"), 3, 1);
        Comment realComment = commentRepository.findById(1L);
        assertEquals(expectedComment, realComment);
    }

    @Test
    public void saveTest() {
        commentRepository.setPersistentClass(Comment.class);

        Comment expectedComment = new Comment("Очередное сообщение", new LocalDateTime("2013-07-20T05:25:00"), 3, 3);
        Comment realComment = commentRepository.save(expectedComment);
        assertEquals(expectedComment, realComment);
    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deleteTest() {
        commentRepository.setPersistentClass(Comment.class);

        Comment comment = commentRepository.findById(2L);

        commentRepository.delete(comment);

        commentRepository.findById(2L);
    }

    @Test
    public void updateTest() {
        commentRepository.setPersistentClass(Comment.class);

        Comment comment = commentRepository.findById(3L);
        assertEquals("Третье сообщение", comment.getText());

        comment.setText("Обновлено");
        commentRepository.update(comment);

        comment = commentRepository.findById(3L);
        assertEquals("Обновлено", comment.getText());
    }


}
