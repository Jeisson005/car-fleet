package com.agence.carfleet.security.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.agence.carfleet.security.models.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    @Value("${car-fleet.username}")
    private String username;

    @Value("${car-fleet.password}")
    private String password;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        if (user.equals(username))
            return new User(username, passwordEncoder.encode(password));
        throw new UsernameNotFoundException("User not found");
    }

}
