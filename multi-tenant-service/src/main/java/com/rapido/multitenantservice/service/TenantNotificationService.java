package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.NotificationRequest;
import com.rapido.multitenantservice.entity.TenantNotification;
import com.rapido.multitenantservice.repository.TenantNotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantNotificationService {

    private final TenantNotificationRepository repository;

    public TenantNotificationService(
            TenantNotificationRepository repository) {
        this.repository = repository;
    }

    public TenantNotification send(
            String tenantId,
            NotificationRequest request) {

        TenantNotification notification =
                new TenantNotification();

        notification.setTenantId(tenantId);
        notification.setNotificationType(
                request.getNotificationType());
        notification.setRecipient(
                request.getRecipient());
        notification.setMessage(
                request.getMessage());
        notification.setStatus("SENT");

        System.out.println(
                "Notification Sent -> "
                        + tenantId);

        return repository.save(notification);
    }

    public List<TenantNotification> getAll(
            String tenantId) {

        return repository.findByTenantId(
                tenantId);
    }
}