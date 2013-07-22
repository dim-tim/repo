package com.socialcooking.repository.api;


import com.socialcooking.domain.User;

public interface UserRepository extends IGenericRepository<User> {

    //TODO переопределить методы у которых в параметрах передается id (т.к. здесь тип id - String)
}
