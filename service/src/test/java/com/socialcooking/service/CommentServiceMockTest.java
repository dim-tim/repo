package com.socialcooking.service;


import com.socialcooking.domain.Comment;
import com.socialcooking.repository.CommentRepositoryImpl;
import com.socialcooking.repository.api.CommentRepository;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.service.api.GenericService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CommentServiceMockTest extends AbstractGenericServiceMockTest<Comment>{

    @InjectMocks
    private CommentServiceImpl commentService = new CommentServiceImpl();

    @Mock
    private CommentRepository commentRepository = new CommentRepositoryImpl();

    private Comment comment;

    @Override
    protected GenericService<Comment> getService() {
        return commentService;
    }

    @Override
    protected GenericRepository<Comment> getMockRepository() {
        return commentRepository;
    }

    @Override
    protected Comment getEntity() {
        return comment;
    }

    @Before
    public void init() {
        comment = new Comment();
        comment.setId(123L);
    }


}
