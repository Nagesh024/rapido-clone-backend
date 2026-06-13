package com.rapido.globalservice.tax;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tax-rules")
public class TaxRuleController {

    private final TaxRuleService service;

    public TaxRuleController(
            TaxRuleService service
    ) {
        this.service = service;
    }

    @PostMapping
    public TaxRule create(
            @RequestBody TaxRule taxRule
    ) {
        return service.create(taxRule);
    }

    @GetMapping
    public List<TaxRule> getAll() {
        return service.getAll();
    }

    @GetMapping("/{countryCode}/{taxType}")
    public TaxRule getRule(
            @PathVariable String countryCode,
            @PathVariable String taxType
    ) {
        return service.getTaxRule(
                countryCode,
                taxType
        );
    }
}