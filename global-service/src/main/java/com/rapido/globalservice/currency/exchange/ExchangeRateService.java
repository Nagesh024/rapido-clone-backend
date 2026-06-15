package com.rapido.globalservice.currency.exchange;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ExchangeRateService {

    private final ExchangeRateRepository repository;

    public ExchangeRateService(
            ExchangeRateRepository repository
    ) {
        this.repository = repository;
    }

    @Scheduled(cron = "0 0 1 * * *")
    public void updateExchangeRates() {

        saveRate(
                "USD",
                "INR",
                new BigDecimal("86.250000")
        );

        saveRate(
                "USD",
                "AED",
                new BigDecimal("3.670000")
        );

        saveRate(
                "USD",
                "GBP",
                new BigDecimal("0.740000")
        );

        System.out.println(
                "Exchange Rates Updated"
        );
    }

    public void saveRate(
            String base,
            String target,
            BigDecimal rate
    ) {

        LocalDate today = LocalDate.now();

        if(repository
                .findByBaseCurrencyAndTargetCurrencyAndRateDate(
                        base,
                        target,
                        today
                )
                .isPresent()) {

            return;
        }

        ExchangeRate exchangeRate =
                new ExchangeRate();

        exchangeRate.setBaseCurrency(base);
        exchangeRate.setTargetCurrency(target);
        exchangeRate.setRate(rate);
        exchangeRate.setRateDate(today);

        repository.save(exchangeRate);
    }
    public CurrencyConversionResponse convert(
            String from,
            String to,
            BigDecimal amount
    ) {

        ExchangeRate rate =
                repository.findLatest(from, to)
                        .stream()
                        .findFirst()
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Exchange rate not found"
                                ));

        BigDecimal converted =
                amount.multiply(rate.getRate())
                        .setScale(
                                2,
                                java.math.RoundingMode.HALF_UP
                        );

        CurrencyConversionResponse response =
                new CurrencyConversionResponse();

        response.setFromCurrency(from);
        response.setToCurrency(to);
        response.setOriginalAmount(amount);
        response.setExchangeRate(rate.getRate());
        response.setConvertedAmount(converted);

        return response;
    }
}