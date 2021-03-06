package com.socialcooking.service;


import com.socialcooking.domain.Role;
import com.socialcooking.repository.api.GenericRepository;
import com.socialcooking.repository.api.RoleRepository;
import com.socialcooking.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roleService")
@Transactional
public class RoleServiceImpl extends GenericServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleRepository commentRepository;

    @Override
    protected GenericRepository<Role> getRepository() {
        return commentRepository;
    }

}
