package com.github.handioq.shopapp.utils;

import com.github.handioq.shopapp.model.dto.UserDto;
import com.github.handioq.shopapp.model.entity.User;

public class Converter {

    public static User toUserEntity(UserDto userDto) {
        return new User(userDto.getEmail(), userDto.getUsername(),
                userDto.getPassword(), userDto.isEnabled());
    }
}
