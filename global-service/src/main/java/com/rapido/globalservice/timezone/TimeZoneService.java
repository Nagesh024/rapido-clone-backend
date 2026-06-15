package com.rapido.globalservice.timezone;

import com.rapido.globalservice.country.Country;
import com.rapido.globalservice.country.CountryRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class TimeZoneService {

    private final CountryRepository countryRepository;

    public TimeZoneService(
            CountryRepository countryRepository
    ) {
        this.countryRepository =
                countryRepository;
    }

    public ZonedDateTime convertToLocalTime(
            Instant utcTime,
            String countryCode
    ) {

        Country country =
                countryRepository
                        .findByCountryCode(
                                countryCode
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Country not found"
                                ));

        return utcTime.atZone(
                ZoneId.of(
                        country.getTimeZone()
                )
        );
    }
}