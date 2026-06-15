package com.rapido.globalservice.currency.exchange;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ExchangeRateLoader
        implements CommandLineRunner {

    private final ExchangeRateService service;

    public ExchangeRateLoader(
            ExchangeRateService service
    ) {
        this.service = service;
    }

    @Override
    public void run(String... args) {

        service.saveRate(
                "USD",
                "INR",
                new BigDecimal("86.250000")
        );

        service.saveRate(
                "USD",
                "AED",
                new BigDecimal("3.670000")
        );

        service.saveRate(
                "USD",
                "GBP",
                new BigDecimal("0.740000")
        );
    }
}