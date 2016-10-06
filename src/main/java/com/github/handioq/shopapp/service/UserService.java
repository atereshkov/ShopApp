package com.github.handioq.shopapp.service;

import com.github.handioq.shopapp.model.entity.User;

public interface UserService {

    User findByUsername(String name);

    User findByEmail(String email);

    User findOne(long id);

}