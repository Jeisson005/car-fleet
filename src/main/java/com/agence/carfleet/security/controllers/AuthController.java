package com.agence.carfleet.security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agence.carfleet.security.models.LoginRequest;
import com.agence.carfleet.security.models.LoginResponse;
import com.agence.carfleet.security.services.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping()
    public ResponseEntity<LoginResponse> login(HttpServletRequest request, @RequestBody(required = false) LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(request, loginRequest));
    }
}
