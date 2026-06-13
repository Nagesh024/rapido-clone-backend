package com.rapido.globalservice.search;

import org.springframework.stereotype.Component;

@Component
public class CountryIndexResolver {

    public String resolveIndex(
            String countryCode
    ) {

        if (countryCode == null ||
                countryCode.isBlank()) {

            throw new RuntimeException(
                    "Country code is required"
            );
        }

        return "rides-"
                + countryCode.toLowerCase();
    }
}