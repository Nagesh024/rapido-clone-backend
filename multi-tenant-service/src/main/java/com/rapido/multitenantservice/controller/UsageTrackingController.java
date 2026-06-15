package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.UsageTrackingRequest;
import com.rapido.multitenantservice.entity.UsageTracking;
import com.rapido.multitenantservice.service.UsageTrackingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant/usage")
public class UsageTrackingController {

    private final UsageTrackingService service;

    public UsageTrackingController(
            UsageTrackingService service) {
        this.service = service;
    }

    @PostMapping
    public UsageTracking saveUsage(
            @RequestBody UsageTrackingRequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public UsageTracking getUsage() {

        return service.get(
                TenantContext.getTenantId());
    }
}