package com.github.handioq.shopapp.service.impl;

import com.github.handioq.shopapp.model.entity.User;
import com.github.handioq.shopapp.repository.UserRepository;
import com.github.handioq.shopapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findOne(long id) {
        return userRepository.findOne(id);
    }
}