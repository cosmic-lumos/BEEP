package com.cosmic.beep.services;

import com.cosmic.beep.entities.User;
import com.cosmic.beep.exceptions.ResourceNotFound;
import com.cosmic.beep.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsernameOrEmail(username, username).orElseThrow(() -> new ResourceNotFound(0L));
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
