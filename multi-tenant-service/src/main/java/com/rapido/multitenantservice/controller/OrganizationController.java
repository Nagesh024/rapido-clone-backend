package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.entity.Organization;
import com.rapido.multitenantservice.repository.OrganizationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrganizationController {

    private final OrganizationRepository organizationRepository;

    public OrganizationController(
            OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("/organizations")
    public List<Organization> getOrganizations() {

        String tenantId = TenantContext.getTenantId();

        return organizationRepository.findByTenantId(tenantId);
    }
    @GetMapping("/organizations/all")
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }
    @GetMapping("/test-controller")
    public String testController() {
        return "Controller Loaded";
    }
    }