package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.ServiceRegistrationRequest;
import com.rapido.platformengineering.dto.ServiceRegistrationResponse;
import com.rapido.platformengineering.service.ServiceRegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platform/services")
public class ServiceRegistrationController {

    private final ServiceRegistrationService service;

    public ServiceRegistrationController(
            ServiceRegistrationService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceRegistrationResponse register(
            @RequestBody ServiceRegistrationRequest request) {

        return service.register(request);
    }

    @GetMapping
    public List<ServiceRegistrationResponse> getAll() {

        return service.findAll();
    }

    @GetMapping("/{id}")
    public ServiceRegistrationResponse getById(
            @PathVariable Long id) {

        return service.findById(id);
    }
}