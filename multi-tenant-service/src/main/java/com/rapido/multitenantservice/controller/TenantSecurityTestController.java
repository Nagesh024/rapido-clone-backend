package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.entity.Organization;
import com.rapido.multitenantservice.repository.OrganizationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/security-test")
public class TenantSecurityTestController {

    private final OrganizationRepository organizationRepository;

    public TenantSecurityTestController(
            OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("/organizations")
    public List<Organization> getOrganizations() {

        String tenantId = TenantContext.getTenantId();

        return organizationRepository
                .findByTenantId(tenantId);
    }
}