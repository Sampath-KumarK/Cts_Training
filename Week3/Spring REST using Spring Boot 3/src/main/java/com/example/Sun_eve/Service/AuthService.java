package com.example.Sun_eve.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Sun_eve.Modules.AuthRequest;
import com.example.Sun_eve.Modules.AuthResponse;

@Service
public class AuthService {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "admin123";

    private final JwtUtil jwtUtil;

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse authenticate(AuthRequest authRequest) {
        if (authRequest == null
                || !VALID_USERNAME.equals(authRequest.getUsername())
                || !VALID_PASSWORD.equals(authRequest.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }

        return new AuthResponse(jwtUtil.generateToken(authRequest.getUsername()));
    }
}