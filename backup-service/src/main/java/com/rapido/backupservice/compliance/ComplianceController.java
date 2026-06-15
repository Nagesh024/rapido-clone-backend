package com.rapido.backupservice.compliance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComplianceController {

    private final RetentionPolicyService retentionPolicyService;
    private final DataDeletionService dataDeletionService;
    private final CountryRetentionService countryRetentionService;

    public ComplianceController(
            RetentionPolicyService retentionPolicyService,
            DataDeletionService dataDeletionService,
            CountryRetentionService countryRetentionService) {

        this.retentionPolicyService = retentionPolicyService;
        this.dataDeletionService = dataDeletionService;
        this.countryRetentionService = countryRetentionService;
    }

    @GetMapping("/compliance/retention")
    public String retention() {

        return retentionPolicyService.retentionPolicy();
    }

    @GetMapping("/compliance/delete")
    public String delete() {

        return dataDeletionService.deleteExpiredData();
    }

    @GetMapping("/compliance/country")
    public String country() {

        return countryRetentionService.countryRules();
    }
}