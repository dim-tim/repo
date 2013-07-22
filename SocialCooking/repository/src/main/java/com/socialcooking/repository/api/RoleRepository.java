package com.socialcooking.repository.api;


import com.socialcooking.domain.Role;

public interface RoleRepository extends IGenericRepository<Role> {

    //TODO переопределить методы у которых в параметрах передается id (т.к. здесь тип id - String)
}
