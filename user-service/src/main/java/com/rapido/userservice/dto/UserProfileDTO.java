package com.rapido.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserProfileDTO {

    @NotBlank
    private String fullName;

    @Email
    private String email;

    private String phone;
    private String profileImage;
    private Boolean active;

    public UserProfileDTO() {
    }

    public UserProfileDTO(String fullName, String email, String phone, String profileImage, Boolean active) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.profileImage = profileImage;
        this.active = active;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public Boolean getActive() {
        return active;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}