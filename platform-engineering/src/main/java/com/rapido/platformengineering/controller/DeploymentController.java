package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.*;
import com.rapido.platformengineering.service.DeploymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/platform/deploy")
public class DeploymentController {

    private final DeploymentService service;

    public DeploymentController(
            DeploymentService service) {

        this.service = service;
    }

    @PostMapping
    public String deploy(
            @RequestBody DeploymentRequest request) {

        return service.deploy(request);
    }

    @PostMapping("/rollback")
    public String rollback(
            @RequestBody RollbackRequest request) {

        return service.rollback(request);
    }

    @GetMapping("/status/{app}")
    public DeploymentStatusResponse status(
            @PathVariable String app) {

        return service.status(app);
    }
}