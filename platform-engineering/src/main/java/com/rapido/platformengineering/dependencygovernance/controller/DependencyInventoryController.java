package com.rapido.platformengineering.dependencygovernance.controller;

import com.rapido.platformengineering.dependencygovernance.entity.DependencyInventory;
import com.rapido.platformengineering.dependencygovernance.service.DependencyInventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dependencies")
public class DependencyInventoryController {

    private final DependencyInventoryService service;

    public DependencyInventoryController(
            DependencyInventoryService service) {
        this.service = service;
    }

    @PostMapping
    public DependencyInventory create(
            @RequestBody DependencyInventory dependency) {
        return service.save(dependency);
    }

    @GetMapping
    public List<DependencyInventory> getAll() {
        return service.findAll();
    }
}