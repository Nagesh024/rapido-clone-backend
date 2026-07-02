package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.InfrastructureHealthResponse;
import org.springframework.stereotype.Service;

@Service
public class InfrastructureHealthService {

    public InfrastructureHealthResponse calculateHealth() {

        InfrastructureHealthResponse response = new InfrastructureHealthResponse();

        response.setCpuUsage(28.0);
        response.setMemoryUsage(42.0);
        response.setAvailability(99.98);
        response.setLatency(90.0);
        response.setErrorRate(0.20);
        response.setDiskUsage(55.0);

        int score = calculateScore(
                response.getCpuUsage(),
                response.getMemoryUsage(),
                response.getAvailability(),
                response.getLatency(),
                response.getErrorRate(),
                response.getDiskUsage());

        response.setInfrastructureHealthScore(score);

        if (score >= 90) {
            response.setStatus("EXCELLENT");
        } else if (score >= 75) {
            response.setStatus("GOOD");
        } else if (score >= 60) {
            response.setStatus("WARNING");
        } else {
            response.setStatus("CRITICAL");
        }

        return response;
    }

    private int calculateScore(double cpu,
                               double memory,
                               double availability,
                               double latency,
                               double errorRate,
                               double disk) {

        double cpuScore = 100 - cpu;
        double memoryScore = 100 - memory;
        double diskScore = 100 - disk;
        double latencyScore = Math.max(0, 100 - latency);
        double errorScore = Math.max(0, 100 - (errorRate * 100));

        double score =
                (cpuScore * 0.20) +
                (memoryScore * 0.20) +
                (availability * 0.25) +
                (latencyScore * 0.15) +
                (errorScore * 0.10) +
                (diskScore * 0.10);

        return (int)Math.round(score);
    }
}