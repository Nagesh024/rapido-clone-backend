package com.rapido.platformservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rapido.platformservice.entity.CountrySetting;
import com.rapido.platformservice.repository.CountrySettingRepository;

@Service
public class CountrySettingService {

    private final CountrySettingRepository repository;

    public CountrySettingService(CountrySettingRepository repository) {
        this.repository = repository;
    }

    public List<CountrySetting> getAllCountrySettings() {
        return repository.findAll();
    }

    public CountrySetting saveCountrySetting(CountrySetting countrySetting) {
        return repository.save(countrySetting);
    }
}