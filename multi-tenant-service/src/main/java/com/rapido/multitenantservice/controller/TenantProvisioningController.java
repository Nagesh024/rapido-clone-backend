package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.dto.TenantProvisionRequest;
import com.rapido.multitenantservice.service.TenantProvisioningService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/tenants")
public class TenantProvisioningController {

    private final TenantProvisioningService service;

    public TenantProvisioningController(
            TenantProvisioningService service) {
        this.service = service;
    }

    @PostMapping
    public Map<String, String> createTenant(
            @RequestBody TenantProvisionRequest request) {

        service.provisionTenant(request);

        return Map.of(
                "status",
                "TENANT_CREATED");
    }
}