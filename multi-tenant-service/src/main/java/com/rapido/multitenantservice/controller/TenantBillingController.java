package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.TenantBillingRequest;
import com.rapido.multitenantservice.entity.TenantBilling;
import com.rapido.multitenantservice.service.TenantBillingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant/billing")
public class TenantBillingController {

    private final TenantBillingService service;

    public TenantBillingController(
            TenantBillingService service) {
        this.service = service;
    }

    @PostMapping
    public TenantBilling saveBilling(
            @RequestBody TenantBillingRequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public TenantBilling getBilling() {

        return service.get(
                TenantContext.getTenantId());
    }
}