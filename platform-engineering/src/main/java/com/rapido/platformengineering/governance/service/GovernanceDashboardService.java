package com.rapido.platformengineering.governance.service;

import com.rapido.platformengineering.compliance.enums.ComplianceStatus;
import com.rapido.platformengineering.compliance.repository.ComplianceCheckRepository;
import com.rapido.platformengineering.governance.dto.GovernanceDashboardResponse;
import com.rapido.platformengineering.readiness.enums.ReadinessStatus;
import com.rapido.platformengineering.readiness.repository.ProductionReadinessRepository;
import com.rapido.platformengineering.risk.repository.RiskRegisterRepository;
import com.rapido.platformengineering.technicaldebt.repository.TechnicalDebtRepository;
import org.springframework.stereotype.Service;

@Service
public class GovernanceDashboardService {

    private final TechnicalDebtRepository technicalDebtRepository;
    private final RiskRegisterRepository riskRegisterRepository;
    private final ComplianceCheckRepository complianceRepository;
    private final ProductionReadinessRepository readinessRepository;

    public GovernanceDashboardService(
            TechnicalDebtRepository technicalDebtRepository,
            RiskRegisterRepository riskRegisterRepository,
            ComplianceCheckRepository complianceRepository,
            ProductionReadinessRepository readinessRepository) {

        this.technicalDebtRepository = technicalDebtRepository;
        this.riskRegisterRepository = riskRegisterRepository;
        this.complianceRepository = complianceRepository;
        this.readinessRepository = readinessRepository;
    }

    public GovernanceDashboardResponse getDashboard() {

        GovernanceDashboardResponse response =
                new GovernanceDashboardResponse();

        response.setTotalTechnicalDebt(
                technicalDebtRepository.count());

        response.setTotalRisks(
                riskRegisterRepository.count());

        response.setTotalComplianceChecks(
                complianceRepository.count());

        response.setCompliantServices(
                complianceRepository.countByStatus(
                        ComplianceStatus.COMPLIANT));

        response.setNonCompliantServices(
                complianceRepository.countByStatus(
                        ComplianceStatus.NON_COMPLIANT));

        response.setProductionReadyServices(
                readinessRepository.countByStatus(
                        ReadinessStatus.PRODUCTION_READY));

        response.setNotReadyServices(
                readinessRepository.countByStatus(
                        ReadinessStatus.NOT_READY));

        return response;
    }
}