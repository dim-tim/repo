package com.socialcooking.repository;


import com.socialcooking.domain.Role;
import com.socialcooking.repository.api.RoleRepository;

public class RoleRepositoryImpl extends GenericRepositoryImpl<Role> implements RoleRepository {

    protected RoleRepositoryImpl() {
        super(Role.class);
    }
}
