package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.CostMetricResponse;
import org.springframework.stereotype.Service;

@Service
public class CostMetricService {

    public CostMetricResponse getCosts() {

        return new CostMetricResponse(
                1500.00,
                800.00,
                2500.00,
                1200.00,
                3000.00
        );
    }
}