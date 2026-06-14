package com.rapido.search.service;

import com.rapido.search.dto.HealthResponse;
import org.springframework.stereotype.Service;

@Service
public class HealthMonitoringService {

    public HealthResponse health() {

        HealthResponse response =
                new HealthResponse();

        response.setElasticsearch("UP");
        response.setKafka("UP");
        response.setRedis("UP");
        response.setStatus("HEALTHY");

        return response;
    }
}