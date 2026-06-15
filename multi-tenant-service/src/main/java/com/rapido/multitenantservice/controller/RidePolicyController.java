package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.RidePolicyRequest;
import com.rapido.multitenantservice.entity.RidePolicy;
import com.rapido.multitenantservice.service.RidePolicyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant/policies")
public class RidePolicyController {

    private final RidePolicyService service;

    public RidePolicyController(
            RidePolicyService service) {
        this.service = service;
    }

    @PostMapping
    public RidePolicy createPolicy(
            @RequestBody RidePolicyRequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public List<RidePolicy> getPolicies() {

        return service.getPolicies(
                TenantContext.getTenantId());
    }
}