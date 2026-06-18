package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.DashboardSummaryDTO;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    public DashboardSummaryDTO summary() {

        return new DashboardSummaryDTO(
                5,
                4,
                12,
                0
        );
    }
}