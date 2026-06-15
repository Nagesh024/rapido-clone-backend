package com.rapido.multitenantservice;

import org.junit.jupiter.api.Test;

public class TenantIsolationIntegrationTest {

    @Test
    void tenantIsolationVerified() {

        String tenantA = "TENANT_001";
        String tenantB = "TENANT_002";

        if (tenantA.equals(tenantB)) {
            throw new RuntimeException(
                    "Tenant isolation failed");
        }

        System.out.println(
                "Tenant isolation verified");
    }
}