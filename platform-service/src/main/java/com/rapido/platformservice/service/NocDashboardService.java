package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.NocDashboardResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NocDashboardService {

    public NocDashboardResponse getDashboard() {

        NocDashboardResponse response = new NocDashboardResponse();

        response.setClusterStatus("HEALTHY");
        response.setApiGatewayStatus("UP");
        response.setDatabaseStatus("UP");
        response.setRedisStatus("UP");
        response.setKafkaStatus("UP");

        response.setCpuUsage(32.4);
        response.setMemoryUsage(48.6);
        response.setDiskUsage(61.8);

        response.setApiLatency(87.3);

        response.setUptime(99.99);

        response.setTimestamp(LocalDateTime.now().toString());

        return response;
    }
}