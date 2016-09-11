package com.github.handioq.shopapp.service;

import com.github.handioq.shopapp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        com.github.handioq.shopapp.model.User user = userService.findByUsername(name);

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), getUserRoles(user.getRoles()));
    }

    private List<SimpleGrantedAuthority> getUserRoles(List<Role> userRoles) {
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.addAll(userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));

        return new ArrayList<>(grantedAuthorities);
    }
}
