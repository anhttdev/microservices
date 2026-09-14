package com.example.userservice.controller;

import com.example.userservice.dto.AuthRequest;
import com.example.userservice.sercurity.UserJwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserJwtUtil userJwtUtil;

    public AuthController(UserJwtUtil userJwtUtil) {
        this.userJwtUtil = userJwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        // Simple hardcoded check for quick setup; replace with database validation later
        if ("admin".equals(request.getUsername()) && "password".equals(request.getPassword())) {
            String token = userJwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}