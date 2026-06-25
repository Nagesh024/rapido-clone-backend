package com.rapido.platformservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.rapido.platformservice.entity.CountrySetting;
import com.rapido.platformservice.service.CountrySettingService;

@RestController
@RequestMapping("/api/country-settings")
public class CountrySettingController {

    private final CountrySettingService service;

    public CountrySettingController(CountrySettingService service) {
        this.service = service;
    }

    @GetMapping
    public List<CountrySetting> getAllCountrySettings() {
        return service.getAllCountrySettings();
    }

    @PostMapping
    public CountrySetting createCountrySetting(@RequestBody CountrySetting countrySetting) {
        return service.saveCountrySetting(countrySetting);
    }
}