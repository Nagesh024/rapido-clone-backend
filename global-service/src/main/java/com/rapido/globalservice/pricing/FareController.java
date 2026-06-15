package com.rapido.globalservice.pricing;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/fare")
public class FareController {

    private final FareCalculationService service;

    public FareController(
            FareCalculationService service
    ) {
        this.service = service;
    }

    @GetMapping("/calculate")
    public BigDecimal calculate(
            @RequestParam BigDecimal baseFare,
            @RequestParam BigDecimal tax
    ) {
        return service.calculateTotalFare(
                baseFare,
                tax
        );
    }
}