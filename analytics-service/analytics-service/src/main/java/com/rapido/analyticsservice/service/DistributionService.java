package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.DistributionResponse;
import com.rapido.analyticsservice.repository.AuditEventRepository;
import org.springframework.stereotype.Service;

@Service
public class DistributionService {

    private final AuditEventRepository auditEventRepository;

    public DistributionService(
            AuditEventRepository auditEventRepository) {

        this.auditEventRepository =
                auditEventRepository;
    }

    public DistributionResponse getDistribution() {

        DistributionResponse response =
                new DistributionResponse();

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