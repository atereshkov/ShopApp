package com.github.handioq.shopapp.controller;

import com.github.handioq.shopapp.model.dto.UserDto;
import com.github.handioq.shopapp.model.entity.Role;
import com.github.handioq.shopapp.model.entity.User;
import com.github.handioq.shopapp.service.AuthService;
import com.github.handioq.shopapp.service.RoleService;
import com.github.handioq.shopapp.utils.Constants;
import com.github.handioq.shopapp.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + Constants.URL_AUTH)
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    RoleService roleService;

    @RequestMapping("/register")
    @ResponseBody
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        User user = Converter.toUserEntity(userDto);

        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findRole(1));
        user.setRoles(roles);

        authService.register(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
