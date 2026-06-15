package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TenantTestController {

    @GetMapping("/tenant/current")
    public Map<String, String> getCurrentTenant() {

        return Map.of(
                "tenantId",
                TenantContext.getTenantId()
        );
    }
}