package com.rapido.multitenantservice.resolver;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class TenantResolver {

    private static final String TENANT_HEADER = "X-Tenant-ID";

    public String resolveTenant(HttpServletRequest request) {

        String tenantId = request.getHeader(TENANT_HEADER);

        if (tenantId == null || tenantId.isBlank()) {
            throw new IllegalArgumentException(
                    "Missing X-Tenant-ID Header");
        }

        return tenantId;
    }
}