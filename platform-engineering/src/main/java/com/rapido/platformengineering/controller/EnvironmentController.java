package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.EnvironmentRequest;
import com.rapido.platformengineering.dto.EnvironmentResponse;
import com.rapido.platformengineering.service.EnvironmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platform/environments")
public class EnvironmentController {

    private final EnvironmentService service;

    public EnvironmentController(
            EnvironmentService service) {

        this.service = service;
    }

    @PostMapping
    public EnvironmentResponse create(
            @RequestBody EnvironmentRequest request) {

        return service.create(request);
    }

    @GetMapping
    public List<EnvironmentResponse> getAll() {

        return service.getAll();
    }
}