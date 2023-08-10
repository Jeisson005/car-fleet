package com.agence.carfleet.security.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.agence.carfleet.security.models.LoginRequest;
import com.agence.carfleet.security.models.LoginResponse;
import com.agence.carfleet.security.models.User;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtService jwtProvider;

    private final AuthenticationManager authenticationManager;

    public LoginResponse login(HttpServletRequest request, LoginRequest loginRequest) {
        // Renew token
        String token = jwtProvider.getToken(request);
        if (StringUtils.hasText(token) && jwtProvider.isTokenValid(token)) {
            String username = jwtProvider.getUsernameFromToken(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            return new LoginResponse(jwtProvider.generateToken(userDetails));
        }
        // Generate token
        if (loginRequest != null) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            return new LoginResponse(jwtProvider.generateToken(new User(loginRequest)));
        }
        throw new BadCredentialsException("No credentials");
    }

}
