package com.rapido.globalservice.currency;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository repository;

    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    public Currency create(Currency currency) {
        return repository.save(currency);
    }

    public List<Currency> getAll() {
        return repository.findAll();
    }

    public Currency getByCode(String code) {
        return repository.findByCode(code)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Currency not found: " + code
                        ));
    }
}