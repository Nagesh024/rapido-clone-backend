package com.rapido.globalservice.currency;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @PostMapping
    public Currency create(
            @RequestBody Currency currency
    ) {
        return service.create(currency);
    }

    @GetMapping
    public List<Currency> getAll() {
        return service.getAll();
    }

    @GetMapping("/{code}")
    public Currency getByCode(
            @PathVariable String code
    ) {
        return service.getByCode(code);
    }
}