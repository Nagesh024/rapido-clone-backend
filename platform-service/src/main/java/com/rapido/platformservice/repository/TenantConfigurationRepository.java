package com.rapido.platformservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rapido.platformservice.entity.TenantConfiguration;

@Repository
public interface TenantConfigurationRepository extends JpaRepository<TenantConfiguration, Long> {

}