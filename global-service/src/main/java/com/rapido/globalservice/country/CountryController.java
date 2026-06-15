package com.rapido.globalservice.country;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @PostMapping
    public Country create(
            @RequestBody Country country
    ) {
        return service.create(country);
    }

    @GetMapping
    public List<Country> getAll() {
        return service.getAll();
    }

    @GetMapping("/{countryCode}")
    public Country getCountry(
            @PathVariable String countryCode
    ) {
        return service.getByCountryCode(countryCode);
    }
}