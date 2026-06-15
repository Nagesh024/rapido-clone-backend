package com.rapido.globalservice.tax;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TaxCalculationService {

    private final TaxRuleRepository repository;

    public TaxCalculationService(
            TaxRuleRepository repository
    ) {
        this.repository = repository;
    }

    public TaxCalculationResponse calculateTax(
            String countryCode,
            String taxType,
            BigDecimal amount
    ) {

        TaxRule taxRule =
                repository
                        .findByCountryCodeAndTaxType(
                                countryCode,
                                taxType
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Tax rule not found"
                                ));

        BigDecimal taxAmount =
                amount
                        .multiply(
                                taxRule.getPercentage()
                        )
                        .divide(
                                new BigDecimal("100"),
                                2,
                                RoundingMode.HALF_UP
                        );

        BigDecimal totalAmount =
                amount
                        .add(taxAmount)
                        .setScale(
                                2,
                                RoundingMode.HALF_UP
                        );

        TaxCalculationResponse response =
                new TaxCalculationResponse();

        response.setCountryCode(countryCode);
        response.setTaxType(taxType);
        response.setAmount(amount);
        response.setTaxPercentage(
                taxRule.getPercentage()
        );
        response.setTaxAmount(taxAmount);
        response.setTotalAmount(totalAmount);

        return response;
    }
}