package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.TrendResponse;
import com.rapido.analyticsservice.repository.AuditEventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TrendService {

    private final AuditEventRepository auditEventRepository;

    public TrendService(
            AuditEventRepository auditEventRepository) {

        this.auditEventRepository =
                auditEventRepository;
    }

    public TrendResponse getTrends() {

        TrendResponse response =
                new TrendResponse();

        response.setTodayEvents(
                auditEventRepository.countEventsAfter(
                        LocalDateTime.now()
                                .minusDays(1)));

        response.setLast7DaysEvents(
                auditEventRepository.countEventsAfter(
                        LocalDateTime.now()
                                .minusDays(7)));

        response.setLast30DaysEvents(
                auditEventRepository.countEventsAfter(
                        LocalDateTime.now()
                                .minusDays(30)));

        return response;
    }
}