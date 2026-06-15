package com.rapido.globalservice.cache;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    private final CountryCacheService
            cacheService;

    public CacheController(
            CountryCacheService cacheService
    ) {
        this.cacheService = cacheService;
    }

    @PostMapping("/tax/{countryCode}")
    public String tax(
            @PathVariable String countryCode,
            @RequestBody String value
    ) {

        cacheService.saveTax(
                countryCode,
                value
        );

        return "Tax Cached";
    }

    @PostMapping("/pricing/{countryCode}")
    public String pricing(
            @PathVariable String countryCode,
            @RequestBody String value
    ) {

        cacheService.savePricing(
                countryCode,
                value
        );

        return "Pricing Cached";
    }

    @PostMapping("/currency/{countryCode}")
    public String currency(
            @PathVariable String countryCode,
            @RequestBody String value
    ) {

        cacheService.saveCurrency(
                countryCode,
                value
        );

        return "Currency Cached";
    }

    @GetMapping
    public Object get(
            @RequestParam String key
    ) {

        return cacheService.get(key);
    }
}