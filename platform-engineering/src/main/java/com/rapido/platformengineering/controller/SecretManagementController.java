package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.service.SecretManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/secrets")
public class SecretManagementController {

    private final SecretManagementService service;

    public SecretManagementController(SecretManagementService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, String> getSecrets() {
        return service.getSecretInfo();
    }
}