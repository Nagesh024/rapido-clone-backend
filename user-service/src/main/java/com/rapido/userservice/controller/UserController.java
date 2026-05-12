package com.rapido.userservice.controller;

import com.rapido.userservice.dto.UserProfileDTO;
import com.rapido.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDTO> getProfile(Authentication authentication) {
        return ResponseEntity.ok(userService.getProfile(authentication.getName()));
    }

    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile(
            @Valid @RequestBody UserProfileDTO dto,
            Authentication authentication) {

        userService.updateProfile(authentication.getName(), dto);
        return ResponseEntity.ok("Profile Updated");
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "User Service Running Successfully";
    }
}