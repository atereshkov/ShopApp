package com.github.handioq.shopapp.service;

import com.github.handioq.shopapp.model.entity.User;
import com.github.handioq.shopapp.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public void register(User user) {
        authRepository.save(user);
    }

}
