package com.rapido.platformengineering.risk.service;

import com.rapido.platformengineering.risk.enums.RiskSeverity;
import org.springframework.stereotype.Service;

@Service
public class RiskAssessmentService {

    public int calculateRiskScore(
            int impact,
            int likelihood) {

        return impact * likelihood;
    }

    public RiskSeverity classify(int score) {

        if (score >= 16) {
            return RiskSeverity.CRITICAL;
        }

        if (score >= 11) {
            return RiskSeverity.HIGH;
        }

        if (score >= 6) {
            return RiskSeverity.MEDIUM;
        }

        return RiskSeverity.LOW;
    }
}