package ru.rishaleva.springBootSecurity.service;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.rishaleva.springBootSecurity.model.Role;
import ru.rishaleva.springBootSecurity.model.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class MyUserDetailsService implements UserDetailsService {
    UserServiceImpl userServiceImpl;

    @Autowired
    public MyUserDetailsService(UserServiceImpl userService) {
        this.userServiceImpl = userService;
    }

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userServiceImpl.findByUserName(name);
        if (user == null) {
            throw new UsernameNotFoundException("User " + name + " not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                mapRoles(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoles(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
