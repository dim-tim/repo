package com.socialcooking.repository;

import com.socialcooking.domain.Comment;
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
    private CommentRepository commentRepository;

    @Test
    public void findAllTest() {
        List<Comment> comments = commentRepository.findAll();
        assertNotNull(comments);
    }

    @Test
    public void findByIdTest() {
        Comment comment = commentRepository.findById(1L);
        assertEquals("Это первое сообщение", comment.getText());
        assertEquals("2013-07-19 05:25:00", comment.getDate());
    }


}
