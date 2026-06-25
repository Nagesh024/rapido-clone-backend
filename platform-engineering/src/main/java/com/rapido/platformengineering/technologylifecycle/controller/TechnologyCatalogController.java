package com.rapido.platformengineering.technologylifecycle.controller;

import com.rapido.platformengineering.technologylifecycle.entity.TechnologyCatalog;
import com.rapido.platformengineering.technologylifecycle.service.TechnologyCatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/technologies")
public class TechnologyCatalogController {

    private final TechnologyCatalogService service;

    public TechnologyCatalogController(
            TechnologyCatalogService service) {
        this.service = service;
    }

    @PostMapping
    public TechnologyCatalog create(
            @RequestBody TechnologyCatalog technology) {
        return service.save(technology);
    }

    @GetMapping
    public List<TechnologyCatalog> getAll() {
        return service.findAll();
    }
}