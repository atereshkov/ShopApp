package com.github.handioq.shopapp.service;

import com.github.handioq.shopapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findByUsername(name);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", name));
        }

        //return new org.springframework.security.core.userdetails.User(user.getUsername(),
        //        user.getPassword(), getUserRoles(user.getRoles()));
        return new UserRepositoryUserDetails(user);
    }

    /*private List<SimpleGrantedAuthority> getUserRoles(List<Role> userRoles) {
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.addAll(userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));

        return new ArrayList<>(grantedAuthorities);
    }*/

    // User here refers to my application's domain User object, not Spring Security
    private final static class UserRepositoryUserDetails extends User implements UserDetails {

        private static final long serialVersionUID = 1L;
        private final User user;

        private UserRepositoryUserDetails(User user) {
            super(user);
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.addAll(user.getRoles().stream().map(role ->
                    new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));

            return grantedAuthorities;
        }

        @Override
        public String getUsername() {
            return user.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return user.isEnabled();
        }

    }
}
