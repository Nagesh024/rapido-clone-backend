package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository
        extends JpaRepository<Organization, Long> {

    List<Organization> findByTenantId(String tenantId);
}