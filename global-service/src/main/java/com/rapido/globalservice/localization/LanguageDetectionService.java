package com.rapido.globalservice.localization;

import com.rapido.globalservice.country.Country;
import com.rapido.globalservice.country.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class LanguageDetectionService {

    private final CountryRepository countryRepository;

    public LanguageDetectionService(
            CountryRepository countryRepository
    ) {
        this.countryRepository = countryRepository;
    }

    public String detectLanguage(
            String userLanguage,
            String countryCode,
            String acceptLanguage
    ) {

        // Priority 1: User Preference

        if (userLanguage != null &&
                !userLanguage.isBlank()) {

            return userLanguage;
        }

        // Priority 2: Country Default Language

        if (countryCode != null &&
                !countryCode.isBlank()) {

            Country country =
                    countryRepository
                            .findByCountryCode(countryCode)
                            .orElse(null);

            if (country != null &&
                    country.getDefaultLanguage() != null) {

                return country.getDefaultLanguage();
            }
        }

        // Priority 3: Accept-Language Header

        if (acceptLanguage != null &&
                !acceptLanguage.isBlank()) {

            String[] values =
                    acceptLanguage.split(",");

            if (values.length > 0) {

                String lang =
                        values[0].trim();

                if (lang.contains("-")) {

                    lang =
                            lang.substring(
                                    0,
                                    lang.indexOf("-")
                            );
                }

                return lang;
            }
        }

        // Priority 4: English

        return "en";
    }
}