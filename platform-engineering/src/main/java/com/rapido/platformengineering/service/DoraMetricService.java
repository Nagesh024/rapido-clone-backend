package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.DoraMetricResponse;
import org.springframework.stereotype.Service;

@Service
public class DoraMetricService {

    public DoraMetricResponse getMetrics() {

        return new DoraMetricResponse(
                25,
                2.5,
                1.2,
                4.0
        );
    }
}