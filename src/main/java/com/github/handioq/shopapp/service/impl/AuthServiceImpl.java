package com.github.handioq.shopapp.service.impl;

import com.github.handioq.shopapp.model.entity.User;
import com.github.handioq.shopapp.repository.AuthRepository;
import com.github.handioq.shopapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public void register(User user) {
        authRepository.save(user);
    }

}
