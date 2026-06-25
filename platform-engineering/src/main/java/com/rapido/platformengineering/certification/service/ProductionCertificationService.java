package com.rapido.platformengineering.certification.service;

import com.rapido.platformengineering.certification.entity.ProductionCertification;
import com.rapido.platformengineering.certification.enums.CertificationStatus;
import com.rapido.platformengineering.certification.repository.ProductionCertificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionCertificationService {

    private final ProductionCertificationRepository repository;

    public ProductionCertificationService(
            ProductionCertificationRepository repository) {

        this.repository = repository;
    }

    public ProductionCertification save(
            ProductionCertification certification) {

        boolean certified =
                Boolean.TRUE.equals(certification.getSecurityValidated())
                && Boolean.TRUE.equals(certification.getPerformanceValidated())
                && Boolean.TRUE.equals(certification.getMonitoringValidated())
                && Boolean.TRUE.equals(certification.getRecoveryValidated())
                && Boolean.TRUE.equals(certification.getComplianceValidated())
                && Boolean.TRUE.equals(certification.getDocumentationValidated());

        certification.setCertificationStatus(
                certified
                        ? CertificationStatus.CERTIFIED
                        : CertificationStatus.NOT_CERTIFIED);

        return repository.save(certification);
    }

    public List<ProductionCertification> findAll() {

        return repository.findAll();
    }
}