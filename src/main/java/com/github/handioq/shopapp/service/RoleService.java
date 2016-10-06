package com.github.handioq.shopapp.service;

import com.github.handioq.shopapp.model.entity.Role;
import com.github.handioq.shopapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findRole(long id) {
        return roleRepository.findOne(id);
    }
}
