package com.socialcooking.repository;

import com.socialcooking.domain.Comment;
import com.socialcooking.domain.Recipe;
import com.socialcooking.domain.User;
import com.socialcooking.repository.api.CommentRepository;
import com.socialcooking.repository.api.RecipeRepository;
import com.socialcooking.repository.api.UserRepository;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CommentRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllTest() {
        List<Comment> comments = commentRepository.findAll();
        assertNotNull(comments);
        assertTrue(comments.size()>0);
        assertEquals(4, comments.size());
    }

    @Test
    public void findByIdTest() {
        Comment expectedComment = new Comment(1L, "Это первое сообщение", new LocalDateTime("2013-07-19T05:25:00"), 3, 1);
        Comment realComment = commentRepository.findById(1L);
        assertEquals(expectedComment, realComment);
    }

    @Test
    public void saveTest() throws InterruptedException {
        Comment expectedComment = new Comment("Очередное сообщениее", new LocalDateTime("2013-07-20T05:25:00"), 3, 3);

        Recipe recipe = recipeRepository.findById(1L);
        User user = userRepository.findById(1L);
        expectedComment.setRecipe(recipe);
        expectedComment.setUser(user);

        Comment realComment = commentRepository.save(expectedComment);
        assertEquals(expectedComment, realComment);

        List<Comment> comments = commentRepository.findAll();
        assertEquals(5, comments.size());

    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deleteTest() {
        Comment comment = commentRepository.findById(2L);

        commentRepository.delete(comment);

        commentRepository.findById(2L);
    }

    @Test
    public void deleteByIdTest() {
        commentRepository.deleteById(4L);

        List<Comment> comments = commentRepository.findAll();
        assertEquals(3, comments.size());
    }

    @Test
    public void updateTest() {
        Comment comment = commentRepository.findById(3L);
        assertEquals("Третье сообщение", comment.getText());

        comment.setText("Обновлено");

        commentRepository.save(comment);

        comment = commentRepository.findById(3L);
        assertEquals("Обновлено", comment.getText());
    }

}
