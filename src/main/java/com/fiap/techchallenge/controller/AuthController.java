package com.fiap.techchallenge.controller;

import com.fiap.techchallenge.dto.LoginRequest;
import com.fiap.techchallenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest request) {
        return service.login(request);
    }
}