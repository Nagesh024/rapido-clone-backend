package com.rapido.globalservice.tax;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/tax")
public class TaxCalculationController {

    private final TaxCalculationService service;

    public TaxCalculationController(
            TaxCalculationService service
    ) {
        this.service = service;
    }

    @GetMapping("/calculate")
    public TaxCalculationResponse calculate(
            @RequestParam String countryCode,
            @RequestParam String taxType,
            @RequestParam BigDecimal amount
    ) {

        return service.calculateTax(
                countryCode,
                taxType,
                amount
        );
    }
}