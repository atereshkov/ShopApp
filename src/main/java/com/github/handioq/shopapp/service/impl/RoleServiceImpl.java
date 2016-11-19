package com.github.handioq.shopapp.service.impl;

import com.github.handioq.shopapp.model.entity.Role;
import com.github.handioq.shopapp.repository.RoleRepository;
import com.github.handioq.shopapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRole(long id) {
        return roleRepository.findOne(id);
    }
}
