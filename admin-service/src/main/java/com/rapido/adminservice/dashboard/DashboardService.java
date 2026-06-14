package com.rapido.adminservice.dashboard;

import com.rapido.adminservice.dashboard.dto.DashboardSummaryResponse;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    public DashboardSummaryResponse getSummary() {
        return new DashboardSummaryResponse(
                1200L,
                150L,
                900L,
                45000.0,
                25L,
                40L
        );
    }
}