package com.rapido.platformengineering.dto;

public record OnboardingRequest(

        String developerName,
        String email,
        String roleName

) {
}