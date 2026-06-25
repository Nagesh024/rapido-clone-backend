package com.rapido.platformengineering.architecturereview.repository;

import com.rapido.platformengineering.architecturereview.entity.ArchitectureReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchitectureReviewRepository
        extends JpaRepository<ArchitectureReview, Long> {
}