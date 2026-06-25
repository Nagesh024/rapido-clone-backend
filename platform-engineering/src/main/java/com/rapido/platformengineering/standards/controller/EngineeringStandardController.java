package com.rapido.platformengineering.standards.controller;

import com.rapido.platformengineering.standards.entity.EngineeringStandard;
import com.rapido.platformengineering.standards.enums.StandardCategory;
import com.rapido.platformengineering.standards.service.EngineeringStandardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/standards")
public class EngineeringStandardController {

    private final EngineeringStandardService service;

    public EngineeringStandardController(
            EngineeringStandardService service) {
        this.service = service;
    }

    @PostMapping
    public EngineeringStandard create(
            @RequestBody EngineeringStandard standard) {
        return service.save(standard);
    }

    @GetMapping
    public List<EngineeringStandard> getAll() {
        return service.getAll();
    }

    @GetMapping("/{category}")
    public List<EngineeringStandard> getByCategory(
            @PathVariable StandardCategory category) {
        return service.getByCategory(category);
    }
}