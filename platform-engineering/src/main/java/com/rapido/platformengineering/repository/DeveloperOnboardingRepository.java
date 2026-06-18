package com.rapido.platformengineering.repository;

import com.rapido.platformengineering.entity.DeveloperOnboarding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperOnboardingRepository
        extends JpaRepository<DeveloperOnboarding, Long> {
}