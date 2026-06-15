package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.entity.TenantBilling;
import com.rapido.multitenantservice.service.SubscriptionBillingEngine;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant/billing")
public class SubscriptionBillingController {

    private final SubscriptionBillingEngine engine;

    public SubscriptionBillingController(
            SubscriptionBillingEngine engine) {
        this.engine = engine;
    }

    @PostMapping("/generate")
    public TenantBilling generateBill() {

        return engine.generateBill(
                TenantContext.getTenantId());
    }
}