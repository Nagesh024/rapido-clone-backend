package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.SecurityComplianceResponse;
import org.springframework.stereotype.Service;

@Service
public class SecurityComplianceService {

    public SecurityComplianceResponse getCompliance() {

        return new SecurityComplianceResponse(
                "PASSED",
                "PASSED",
                "PASSED",
                "PASSED"
        );
    }
}