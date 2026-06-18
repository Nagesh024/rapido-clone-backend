package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.*;
import com.rapido.platformengineering.entity.DeveloperOnboarding;
import com.rapido.platformengineering.repository.DeveloperOnboardingRepository;
import org.springframework.stereotype.Service;

@Service
public class DeveloperOnboardingService {

    private final DeveloperOnboardingRepository repository;

    public DeveloperOnboardingService(
            DeveloperOnboardingRepository repository) {

        this.repository = repository;
    }

    public OnboardingResponse onboard(
            OnboardingRequest request) {

        DeveloperOnboarding developer =
                new DeveloperOnboarding();

        developer.setDeveloperName(
                request.developerName());

        developer.setEmail(
                request.email());

        developer.setRoleName(
                request.roleName());

        developer.setAccessGranted(true);

        developer.setEnvironmentName(
                "dev-environment");

        developer.setStatus(
                "COMPLETED");

        DeveloperOnboarding saved =
                repository.save(developer);

        return new OnboardingResponse(
                saved.getId(),
                saved.getDeveloperName(),
                saved.getRoleName(),
                saved.getAccessGranted(),
                saved.getEnvironmentName(),
                saved.getStatus()
        );
    }
}