package com.rapido.platformengineering.dto;

public record SecurityComplianceResponse(

        String containerScanning,
        String dependencyScanning,
        String secretScanning,
        String policyCompliance

) {
}