package com.rapido.globalservice.timezone;

import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/timezone")
public class TimeZoneController {

    private final TimeZoneService service;

    public TimeZoneController(
            TimeZoneService service
    ) {
        this.service = service;
    }

    @GetMapping("/current")
    public TimeZoneResponse getTime(
            @RequestParam String countryCode
    ) {

        Instant utc =
                Instant.now();

        ZonedDateTime local =
                service.convertToLocalTime(
                        utc,
                        countryCode
                );

        return new TimeZoneResponse(
                utc.toString(),
                local.toString()
        );
    }
}