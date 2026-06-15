package com.rapido.globalservice.pricing;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PricingRuleRepository
        extends JpaRepository<PricingRule, Long> {

    Optional<PricingRule> findByCountryCodeAndCityCodeAndVehicleType(
            String countryCode,
            String cityCode,
            String vehicleType
    );
}