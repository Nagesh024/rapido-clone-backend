package com.rapido.globalservice.pricing;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class InternationalPricingService {

    private final PricingRuleRepository repository;

    public InternationalPricingService(
            PricingRuleRepository repository
    ) {
        this.repository = repository;
    }

    public PricingResponse calculateFare(
            String countryCode,
            String cityCode,
            String vehicleType
    ) {

        PricingRule rule =
                repository
                        .findByCountryCodeAndCityCodeAndVehicleType(
                                countryCode,
                                cityCode,
                                vehicleType
                        )
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Pricing rule not found"
                                ));

        BigDecimal subtotal =
                rule.getBaseFare()
                        .add(rule.getCityAdjustment());

        BigDecimal surgedFare =
                subtotal.multiply(
                        rule.getPeakSurgeMultiplier()
                );

        BigDecimal surgeAmount =
                surgedFare.subtract(subtotal);

        BigDecimal taxAmount =
                surgedFare
                        .multiply(rule.getTaxPercentage())
                        .divide(
                                new BigDecimal("100"),
                                2,
                                RoundingMode.HALF_UP
                        );

        BigDecimal total =
                surgedFare
                        .add(taxAmount)
                        .setScale(
                                2,
                                RoundingMode.HALF_UP
                        );

        PricingResponse response =
                new PricingResponse();

        response.setBaseFare(rule.getBaseFare());
        response.setCityAdjustment(
                rule.getCityAdjustment()
        );
        response.setSurgeAmount(
                surgeAmount.setScale(
                        2,
                        RoundingMode.HALF_UP
                )
        );
        response.setTaxAmount(taxAmount);
        response.setTotalFare(total);

        return response;
    }
}