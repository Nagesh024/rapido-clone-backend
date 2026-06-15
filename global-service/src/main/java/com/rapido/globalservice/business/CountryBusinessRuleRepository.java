package com.rapido.globalservice.business;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryBusinessRuleRepository
        extends JpaRepository<CountryBusinessRule, Long> {

    Optional<CountryBusinessRule>
    findByCountryCodeAndVehicleTypeAndActive(
            String countryCode,
            String vehicleType,
            Boolean active
    );
}