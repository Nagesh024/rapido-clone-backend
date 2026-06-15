package com.rapido.globalservice.country;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public Country create(Country country) {
        return repository.save(country);
    }

    public List<Country> getAll() {
        return repository.findAll();
    }

    public Country getByCountryCode(String countryCode) {
        return repository.findByCountryCode(countryCode)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Country not found: " + countryCode
                        ));
    }
}