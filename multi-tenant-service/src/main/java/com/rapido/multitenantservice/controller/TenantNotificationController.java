package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.context.TenantContext;
import com.rapido.multitenantservice.dto.NotificationRequest;
import com.rapido.multitenantservice.entity.TenantNotification;
import com.rapido.multitenantservice.service.TenantNotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenant/notifications")
public class TenantNotificationController {

    private final TenantNotificationService service;

    public TenantNotificationController(
            TenantNotificationService service) {
        this.service = service;
    }

    @PostMapping
    public TenantNotification sendNotification(
            @RequestBody NotificationRequest request) {

        return service.send(
                TenantContext.getTenantId(),
                request);
    }

    @GetMapping
    public List<TenantNotification> getNotifications() {

        return service.getAll(
                TenantContext.getTenantId());
    }
}