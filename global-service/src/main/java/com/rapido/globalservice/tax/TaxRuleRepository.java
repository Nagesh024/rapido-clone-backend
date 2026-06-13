package com.rapido.globalservice.tax;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaxRuleRepository
        extends JpaRepository<TaxRule, Long> {

    Optional<TaxRule> findByCountryCodeAndTaxType(
            String countryCode,
            String taxType
    );
}