package com.rapido.globalservice.tax;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxRuleService {

    private final TaxRuleRepository repository;

    public TaxRuleService(
            TaxRuleRepository repository
    ) {
        this.repository = repository;
    }

    public TaxRule create(
            TaxRule taxRule
    ) {
        return repository.save(taxRule);
    }

    public List<TaxRule> getAll() {
        return repository.findAll();
    }

    public TaxRule getTaxRule(
            String countryCode,
            String taxType
    ) {
        return repository
                .findByCountryCodeAndTaxType(
                        countryCode,
                        taxType
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Tax Rule Not Found"
                        ));
    }
}