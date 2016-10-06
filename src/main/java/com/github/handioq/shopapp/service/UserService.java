package com.github.handioq.shopapp.service;

import com.github.handioq.shopapp.model.entity.User;
import com.github.handioq.shopapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findOne(long id) {
        return userRepository.findOne(id);
    }
}