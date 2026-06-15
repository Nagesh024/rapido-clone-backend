package com.rapido.globalservice.pricing;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pricing")
public class InternationalPricingController {

    private final InternationalPricingService service;

    public InternationalPricingController(
            InternationalPricingService service
    ) {
        this.service = service;
    }

    @GetMapping("/calculate")
    public PricingResponse calculate(
            @RequestParam String countryCode,
            @RequestParam String cityCode,
            @RequestParam String vehicleType
    ) {

        return service.calculateFare(
                countryCode,
                cityCode,
                vehicleType
        );
    }
}