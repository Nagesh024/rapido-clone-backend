package com.rapido.platformengineering.technicaldebt.service;

import com.rapido.platformengineering.technicaldebt.entity.TechnicalDebt;
import com.rapido.platformengineering.technicaldebt.enums.DebtSeverity;
import org.springframework.stereotype.Service;

@Service
public class TechnicalDebtScoringService {

    public int calculateRiskScore(
            int businessImpact,
            int technicalImpact,
            int probability) {

        return businessImpact
                * technicalImpact
                * probability;
    }

    public DebtSeverity classify(int score) {

        if (score <= 100) {
            return DebtSeverity.LOW;
        }

        if (score <= 300) {
            return DebtSeverity.MEDIUM;
        }

        if (score <= 700) {
            return DebtSeverity.HIGH;
        }

        return DebtSeverity.CRITICAL;
    }

    public void score(TechnicalDebt debt) {

        int riskScore =
                calculateRiskScore(
                        debt.getBusinessImpact(),
                        debt.getTechnicalImpact(),
                        debt.getProbability());

        debt.setRiskScore(riskScore);

        debt.setSeverity(
                classify(riskScore));
    }
}