package com.rapido.globalservice.compliance;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compliance")
public class ComplianceConfigurationController {

    private final ComplianceConfigurationService service;

    public ComplianceConfigurationController(
            ComplianceConfigurationService service
    ) {
        this.service = service;
    }

    @GetMapping("/{countryCode}")
    public ComplianceConfiguration getConfiguration(
            @PathVariable String countryCode
    ) {

        return service.getConfiguration(
                countryCode
        );
    }
}