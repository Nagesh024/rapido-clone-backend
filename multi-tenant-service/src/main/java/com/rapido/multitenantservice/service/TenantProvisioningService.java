package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.TenantProvisionRequest;
import com.rapido.multitenantservice.entity.*;
import com.rapido.multitenantservice.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TenantProvisioningService {

    private final OrganizationRepository organizationRepository;
    private final TenantRepository tenantRepository;
    private final RoleRepository roleRepository;
    private final AdminUserRepository adminUserRepository;
    private final BrandingConfigurationRepository brandingRepository;
    private final TenantConfigurationRepository configRepository;

    public TenantProvisioningService(
            OrganizationRepository organizationRepository,
            TenantRepository tenantRepository,
            RoleRepository roleRepository,
            AdminUserRepository adminUserRepository,
            BrandingConfigurationRepository brandingRepository,
            TenantConfigurationRepository configRepository) {

        this.organizationRepository = organizationRepository;
        this.tenantRepository = tenantRepository;
        this.roleRepository = roleRepository;
        this.adminUserRepository = adminUserRepository;
        this.brandingRepository = brandingRepository;
        this.configRepository = configRepository;
    }

    @Transactional
    public void provisionTenant(TenantProvisionRequest request) {

        String tenantId = request.getTenantCode();

        Organization org = new Organization();
        org.setTenantId(tenantId);
        org.setOrganizationName(request.getOrganizationName());
        org.setOrganizationCode(request.getTenantCode());
        org.setSubscriptionPlan("STARTER");
        org.setActive(true);

        organizationRepository.save(org);

        Tenant tenant = new Tenant();
        tenant.setTenantId(tenantId);
        tenant.setTenantCode(request.getTenantCode());
        tenant.setOrganizationId(org.getId());
        tenant.setStatus("ACTIVE");

        tenantRepository.save(tenant);

        Role role = new Role();
        role.setTenantId(tenantId);
        role.setRoleName("ADMIN");

        roleRepository.save(role);

        AdminUser admin = new AdminUser();
        admin.setTenantId(tenantId);
        admin.setUsername(request.getAdminUsername());
        admin.setEmail(request.getAdminEmail());
        admin.setPassword("admin123");
        admin.setRole("ADMIN");

        adminUserRepository.save(admin);

        BrandingConfiguration branding =
                new BrandingConfiguration();

        branding.setTenantId(tenantId);
        branding.setCompanyName(request.getOrganizationName());
        branding.setPrimaryColor("#0099FF");
        branding.setLogoUrl("default-logo.png");

        brandingRepository.save(branding);

        TenantConfiguration config =
                new TenantConfiguration();

        config.setTenantId(tenantId);
        config.setPricingRule("STANDARD");
        config.setCommissionRule("10_PERCENT");
        config.setRideCategory("BIKE");

        configRepository.save(config);
    }
}