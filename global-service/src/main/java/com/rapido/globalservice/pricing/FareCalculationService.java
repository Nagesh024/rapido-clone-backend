package com.rapido.globalservice.pricing;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class FareCalculationService {

    public BigDecimal calculateTotalFare(
            BigDecimal baseFare,
            BigDecimal taxPercentage
    ) {

        BigDecimal tax =
                baseFare
                        .multiply(taxPercentage)
                        .divide(
                                new BigDecimal("100"),
                                2,
                                RoundingMode.HALF_UP
                        );

        return baseFare
                .add(tax)
                .setScale(
                        2,
                        RoundingMode.HALF_UP
                );
    }
}