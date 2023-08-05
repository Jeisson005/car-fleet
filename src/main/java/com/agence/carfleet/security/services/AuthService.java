package com.agence.carfleet.security.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.agence.carfleet.security.models.LoginRequest;
import com.agence.carfleet.security.models.LoginResponse;
import com.agence.carfleet.security.models.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtProvider;

    private final AuthenticationManager authenticationManager;

    public LoginResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        return new LoginResponse(jwtProvider.generateToken(new User(loginRequest)));
    }
}
