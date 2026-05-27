package com.rapido.authservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rapido.authservice.dto.ApiResponse;
import com.rapido.authservice.dto.LoginRequest;
import com.rapido.authservice.dto.RegisterRequest;
import com.rapido.authservice.entity.User;
import com.rapido.authservice.repository.UserRepository;
import com.rapido.authservice.util.JwtUtil;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtutil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtutil;
    }

    public ApiResponse<Object> register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return new ApiResponse<>(false, "Email already registered", null);
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());

        userRepository.save(user);

        return new ApiResponse<>(true, "User registered successfully", null);
    }

    public ApiResponse<Object> login(LoginRequest request) {

        User user =
                userRepository.findByEmail(request.getEmail()).orElse(null);

        if (user == null) {
            return new ApiResponse<>(false, "User not found", null);
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return new ApiResponse<>(false, "Invalid password", null);
        }

        String token =
                jwtUtil.generateToken(user.getEmail());

        return new ApiResponse<>(true,
                "Login successful",
                token);
    }
}