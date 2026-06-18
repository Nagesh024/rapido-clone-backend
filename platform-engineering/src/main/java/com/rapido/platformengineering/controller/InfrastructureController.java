package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.InfrastructureProvisionRequest;
import com.rapido.platformengineering.dto.InfrastructureProvisionResponse;
import com.rapido.platformengineering.service.InfrastructureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platform/infrastructure")
public class InfrastructureController {

    private final InfrastructureService service;

    public InfrastructureController(
            InfrastructureService service) {
        this.service = service;
    }

    @PostMapping("/provision")
    public InfrastructureProvisionResponse provision(
            @RequestBody InfrastructureProvisionRequest request) {

        return service.provision(request);
    }

    @GetMapping
    public List<InfrastructureProvisionResponse> getAll() {

        return service.getAll();
    }
}