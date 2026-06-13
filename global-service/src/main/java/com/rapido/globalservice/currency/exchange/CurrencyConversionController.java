package com.rapido.globalservice.currency.exchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency")
public class CurrencyConversionController {

    private final ExchangeRateService service;

    public CurrencyConversionController(
            ExchangeRateService service
    ) {
        this.service = service;
    }

    @GetMapping("/convert")
    public CurrencyConversionResponse convert(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam BigDecimal amount
    ) {
        return service.convert(
                from,
                to,
                amount
        );
    }
}