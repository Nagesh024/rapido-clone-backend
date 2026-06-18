package com.rapido.platformengineering.dto;

public record OnboardingResponse(

        Long id,
        String developerName,
        String roleName,
        Boolean accessGranted,
        String environmentName,
        String status

) {
}