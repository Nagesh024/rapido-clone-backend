package com.rapido.platformservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rapido.platformservice.entity.PricingRule;

@Repository
public interface PricingRuleRepository extends JpaRepository<PricingRule, Long> {

}