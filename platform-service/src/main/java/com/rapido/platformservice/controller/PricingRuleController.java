package com.rapido.platformservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.rapido.platformservice.entity.PricingRule;
import com.rapido.platformservice.service.PricingRuleService;

@RestController
@RequestMapping("/api/pricing-rules")
public class PricingRuleController {

    private final PricingRuleService service;

    public PricingRuleController(PricingRuleService service) {
        this.service = service;
    }

    @GetMapping
    public List<PricingRule> getAllPricingRules() {
        return service.getAllPricingRules();
    }

    @PostMapping
    public PricingRule createPricingRule(@RequestBody PricingRule pricingRule) {
        return service.savePricingRule(pricingRule);
    }
}