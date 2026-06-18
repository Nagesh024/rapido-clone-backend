package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.ServiceCatalogRequest;
import com.rapido.platformengineering.dto.ServiceCatalogResponse;
import com.rapido.platformengineering.service.ServiceCatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class ServiceCatalogController {

    private final ServiceCatalogService service;

    public ServiceCatalogController(ServiceCatalogService service) {
        this.service = service;
    }

    @PostMapping
    public ServiceCatalogResponse register(
            @RequestBody ServiceCatalogRequest request) {

        return service.register(request);
    }

    @GetMapping
    public List<ServiceCatalogResponse> getAll() {
        return service.getAll();
    }
}