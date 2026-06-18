package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.*;
import com.rapido.platformengineering.service.DeveloperOnboardingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/onboarding")
public class DeveloperOnboardingController {

    private final DeveloperOnboardingService service;

    public DeveloperOnboardingController(
            DeveloperOnboardingService service) {

        this.service = service;
    }

    @PostMapping
    public OnboardingResponse onboard(

            @RequestBody
            OnboardingRequest request) {

        return service.onboard(request);
    }
}