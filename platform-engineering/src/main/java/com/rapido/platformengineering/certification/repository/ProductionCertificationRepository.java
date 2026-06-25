package com.rapido.platformengineering.certification.repository;

import com.rapido.platformengineering.certification.entity.ProductionCertification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionCertificationRepository
        extends JpaRepository<ProductionCertification, Long> {
}