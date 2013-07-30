package com.socialcooking.service;


import com.socialcooking.domain.User;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.UserRepository;
import com.socialcooking.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

    @Autowired
    private UserRepository commentRepository;

    @Override
    protected GenericRepository<User> getRepository() {
        return commentRepository;
    }

}
