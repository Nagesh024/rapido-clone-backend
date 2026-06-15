package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.PricingRuleRequest;
import com.rapido.multitenantservice.entity.PricingRule;
import com.rapido.multitenantservice.service.PricingRuleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant/pricing")
public class PricingRuleController {

    private final PricingRuleService service;

    public PricingRuleController(
            PricingRuleService service) {
        this.service = service;
    }

    @PostMapping
    public PricingRule savePricing(
            @RequestBody PricingRuleRequest request) {

        return service.save(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public PricingRule getPricing() {

        return service.get(
                TenantContext.getTenantId());
    }
}