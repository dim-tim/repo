package com.socialcooking.repository;

import com.socialcooking.domain.User;
import com.socialcooking.repository.api.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mikalai Kisel
 */

@Service("UserRepository")
@Repository
@Transactional
public class UserRepositoryImpl extends GenericRepositoryImpl<User> implements UserRepository{
}
