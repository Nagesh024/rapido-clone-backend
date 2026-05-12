package com.rapido.userservice.service;

import org.springframework.stereotype.Service;

import com.rapido.userservice.dto.UserProfileDTO;
import com.rapido.userservice.entity.User;
import com.rapido.userservice.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

     public UserProfileDTO getProfile(String email) {
    email = "testuser@gmail.com";

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserProfileDTO(
                user.getFullName(),
                user.getEmail(),
                user.getPhone(),
                user.getProfileImage(),
                user.getActive()
        );
    }

    public void updateProfile(String email, UserProfileDTO dto) {
    email = "testuser@gmail.com";

    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFullName(dto.getFullName());
        user.setPhone(dto.getPhone());
        user.setProfileImage(dto.getProfileImage());
        user.setActive(dto.getActive());

        userRepository.save(user);
    }
}