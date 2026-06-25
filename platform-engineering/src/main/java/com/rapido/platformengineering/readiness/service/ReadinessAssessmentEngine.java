package com.rapido.platformengineering.readiness.service;

import com.rapido.platformengineering.readiness.enums.ReadinessStatus;
import org.springframework.stereotype.Service;

@Service
public class ReadinessAssessmentEngine {

    public int calculateScore(
            int monitoring,
            int security,
            int performance,
            int scalability,
            int disasterRecovery,
            int compliance) {

        return monitoring
                + security
                + performance
                + scalability
                + disasterRecovery
                + compliance;
    }

    public ReadinessStatus evaluate(int score) {

        if (score >= 80) {
            return ReadinessStatus.PRODUCTION_READY;
        }

        return ReadinessStatus.NOT_READY;
    }
}