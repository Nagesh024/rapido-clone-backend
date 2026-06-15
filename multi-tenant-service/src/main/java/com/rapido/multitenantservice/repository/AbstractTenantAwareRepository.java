package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.context.TenantContext;

public abstract class AbstractTenantAwareRepository {

    protected String getCurrentTenantId() {
        return TenantContext.getTenantId();
    }
}