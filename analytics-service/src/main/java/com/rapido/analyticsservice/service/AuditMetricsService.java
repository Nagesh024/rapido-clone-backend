package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.AuditMetricsResponse;
import com.rapido.analyticsservice.repository.AuditEventRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditMetricsService {

    private final AuditEventRepository auditEventRepository;

    public AuditMetricsService(
            AuditEventRepository auditEventRepository) {

        this.auditEventRepository =
                auditEventRepository;
    }

    public AuditMetricsResponse getMetrics() {

        AuditMetricsResponse response =
                new AuditMetricsResponse();

        response.setTotalEvents(
                auditEventRepository.count());

        response.setRideEvents(
                auditEventRepository.countByEventType(
                        "RIDE_COMPLETED"));

        response.setPaymentEvents(
                auditEventRepository.countByEventType(
                        "PAYMENT_SUCCESS"));

        response.setDriverEvents(
                auditEventRepository.countByEventType(
                        "DRIVER_STATUS_UPDATED"));

        response.setNotificationEvents(
                auditEventRepository.countByEventType(
                        "NOTIFICATION_SENT"));

        return response;
    }
}