package com.rapido.globalservice.business;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/business-rules")
public class CountryBusinessRuleController {

    private final CountryBusinessRuleService service;

    public CountryBusinessRuleController(
            CountryBusinessRuleService service
    ) {
        this.service = service;
    }

    @GetMapping("/validate")
    public BusinessRuleResponse validate(
            @RequestParam String countryCode,
            @RequestParam String vehicleType
    ) {

        return service.validate(
                countryCode,
                vehicleType
        );
    }
}