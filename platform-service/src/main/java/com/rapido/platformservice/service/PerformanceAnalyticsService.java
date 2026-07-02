package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.PerformanceAnalyticsResponse;
import org.springframework.stereotype.Service;

@Service
public class PerformanceAnalyticsService {

    public PerformanceAnalyticsResponse getPerformanceMetrics() {

        PerformanceAnalyticsResponse response =
                new PerformanceAnalyticsResponse();

        response.setP50Latency(22.4);
        response.setP95Latency(68.9);
        response.setP99Latency(142.6);

        response.setRequestsPerSecond(2845);

        response.setCpuUsage(61.3);

        response.setMemoryUsage(58.7);

        response.setNetworkUsage(742.5);

        if (response.getP99Latency() < 200 &&
                response.getCpuUsage() < 80 &&
                response.getMemoryUsage() < 80) {

            response.setPerformanceStatus("HEALTHY");

        } else {

            response.setPerformanceStatus("WARNING");

        }

        return response;
    }
}