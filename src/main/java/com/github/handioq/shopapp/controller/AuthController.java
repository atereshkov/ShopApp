package com.github.handioq.shopapp.controller;

import com.github.handioq.shopapp.model.dto.UserDto;
import com.github.handioq.shopapp.model.entity.User;
import com.github.handioq.shopapp.service.AuthService;
import com.github.handioq.shopapp.utils.Constants;
import com.github.handioq.shopapp.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API_URL + Constants.URL_AUTH)
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        User user = Converter.toUserEntity(userDto);
        authService.register(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
