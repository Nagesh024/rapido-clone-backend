package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.TenantAlertRequest;
import com.rapido.multitenantservice.entity.TenantAlert;
import com.rapido.multitenantservice.service.TenantAlertService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant/alerts")
public class TenantAlertController {

    private final TenantAlertService service;

    public TenantAlertController(
            TenantAlertService service) {
        this.service = service;
    }

    @PostMapping
    public TenantAlert createAlert(
            @RequestBody TenantAlertRequest request) {

        return service.create(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public List<TenantAlert> getAlerts() {

        return service.getAll(
                TenantContext.getTenantId());
    }
}