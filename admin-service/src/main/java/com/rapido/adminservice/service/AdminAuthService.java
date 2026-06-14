package com.rapido.adminservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rapido.adminservice.dto.AdminLoginRequest;
import com.rapido.adminservice.dto.AdminLoginResponse;
import com.rapido.adminservice.entity.Admin;
import com.rapido.adminservice.repository.AdminRepository;
import com.rapido.adminservice.security.JwtUtil;

@Service
public class AdminAuthService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AdminAuthService(AdminRepository adminRepository,
                            PasswordEncoder passwordEncoder,
                            JwtUtil jwtUtil) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public AdminLoginResponse login(AdminLoginRequest request) {

        Admin admin = adminRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        if (admin.getActive() == null || !admin.getActive()) {
            throw new RuntimeException("Admin account is inactive");
        }

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(admin.getEmail());

        return new AdminLoginResponse(
                token,
                admin.getRole().name(),
                "Admin Login Successful"
        );
    }
}