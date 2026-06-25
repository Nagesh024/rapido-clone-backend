package com.rapido.platformengineering.dashboard.service;

import com.rapido.platformengineering.compliance.enums.ComplianceStatus;
import com.rapido.platformengineering.compliance.repository.ComplianceCheckRepository;
import com.rapido.platformengineering.dashboard.dto.ExecutiveDashboardResponse;
import com.rapido.platformengineering.risk.repository.RiskRegisterRepository;
import com.rapido.platformengineering.technicaldebt.repository.TechnicalDebtRepository;
import org.springframework.stereotype.Service;

@Service
public class ExecutiveDashboardService {

    private final TechnicalDebtRepository technicalDebtRepository;
    private final RiskRegisterRepository riskRegisterRepository;
    private final ComplianceCheckRepository complianceRepository;

    public ExecutiveDashboardService(
            TechnicalDebtRepository technicalDebtRepository,
            RiskRegisterRepository riskRegisterRepository,
            ComplianceCheckRepository complianceRepository) {

        this.technicalDebtRepository = technicalDebtRepository;
        this.riskRegisterRepository = riskRegisterRepository;
        this.complianceRepository = complianceRepository;
    }

    public ExecutiveDashboardResponse getDashboard() {

        ExecutiveDashboardResponse response =
                new ExecutiveDashboardResponse();

        response.setSystemHealth("HEALTHY");

        response.setTechnicalDebtCount(
                technicalDebtRepository.count());

        response.setRiskExposureCount(
                riskRegisterRepository.count());

        response.setCompliantServices(
                complianceRepository.countByStatus(
                        ComplianceStatus.COMPLIANT));

        response.setNonCompliantServices(
                complianceRepository.countByStatus(
                        ComplianceStatus.NON_COMPLIANT));

        return response;
    }
}