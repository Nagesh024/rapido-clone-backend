package com.rapido.authservice.controller;

import com.rapido.authservice.dto.ApiResponse;
import com.rapido.authservice.dto.LoginRequest;
import com.rapido.authservice.dto.RegisterRequest;
import com.rapido.authservice.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/test")
    public String test() {
        return "Auth Controller Working";
    }

    @PostMapping("/register")
    public ApiResponse<Object> register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public ApiResponse<Object> login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
@GetMapping("/profile")
public ApiResponse<Object> profile() {
    return new ApiResponse<>(true, "Profile accessed successfully", "Protected user profile");
}
}