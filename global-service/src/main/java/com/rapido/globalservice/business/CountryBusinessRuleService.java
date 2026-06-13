package com.rapido.globalservice.business;

import org.springframework.stereotype.Service;

@Service
public class CountryBusinessRuleService {

    private final CountryBusinessRuleRepository repository;

    public CountryBusinessRuleService(
            CountryBusinessRuleRepository repository
    ) {
        this.repository = repository;
    }

    public BusinessRuleResponse validate(
            String countryCode,
            String vehicleType
    ) {

        boolean allowed =
                repository
                        .findByCountryCodeAndVehicleTypeAndActive(
                                countryCode,
                                vehicleType,
                                true
                        )
                        .isPresent();

        BusinessRuleResponse response =
                new BusinessRuleResponse();

        response.setCountryCode(countryCode);
        response.setVehicleType(vehicleType);
        response.setAllowed(allowed);

        if (allowed) {

            response.setMessage(
                    "Vehicle type allowed"
            );

        } else {

            response.setMessage(
                    "Vehicle type not allowed"
            );
        }

        return response;
    }
}