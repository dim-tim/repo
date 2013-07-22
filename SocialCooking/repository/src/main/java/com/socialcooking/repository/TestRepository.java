package com.socialcooking.repository;

import com.socialcooking.domain.Comment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mikalai Kisel
 */

@Component("TestRepository")
@Transactional
public class TestRepository extends GenericRepositoryImpl<Comment, Long> {

    public TestRepository() {

    }


}
