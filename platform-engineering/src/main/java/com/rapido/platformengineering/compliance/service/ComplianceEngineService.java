package com.rapido.platformengineering.compliance.service;

import com.rapido.platformengineering.compliance.enums.ComplianceStatus;
import org.springframework.stereotype.Service;

@Service
public class ComplianceEngineService {

    public ComplianceStatus evaluate(
            Boolean microservice,
            Boolean api,
            Boolean security,
            Boolean deployment) {

        if (Boolean.TRUE.equals(microservice)
                && Boolean.TRUE.equals(api)
                && Boolean.TRUE.equals(security)
                && Boolean.TRUE.equals(deployment)) {

            return ComplianceStatus.COMPLIANT;
        }

        return ComplianceStatus.NON_COMPLIANT;
    }
}