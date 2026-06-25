package com.rapido.platformservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rapido.platformservice.entity.PricingRule;
import com.rapido.platformservice.repository.PricingRuleRepository;

@Service
public class PricingRuleService {

    private final PricingRuleRepository repository;

    public PricingRuleService(PricingRuleRepository repository) {
        this.repository = repository;
    }

    public List<PricingRule> getAllPricingRules() {
        return repository.findAll();
    }

    public PricingRule savePricingRule(PricingRule pricingRule) {
        return repository.save(pricingRule);
    }
}