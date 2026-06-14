package com.rapido.adminservice.controller;

import com.rapido.adminservice.dto.AdminLoginRequest;
import com.rapido.adminservice.dto.AdminLoginResponse;
import com.rapido.adminservice.service.AdminAuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/auth")
public class AdminAuthController {

    private final AdminAuthService adminAuthService;

    public AdminAuthController(AdminAuthService adminAuthService) {
        this.adminAuthService = adminAuthService;
    }

    @PostMapping("/login")
    public AdminLoginResponse login(@RequestBody AdminLoginRequest request) {
        return adminAuthService.login(request);
    }

    @GetMapping("/test")
    public String test() {
        return "Admin Auth Controller Working";
    }

    @GetMapping("/exception-test")
    public String exceptionTest() {
        throw new RuntimeException("Test Exception");
    }
}