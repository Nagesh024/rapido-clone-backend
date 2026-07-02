package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.CapacityDashboardResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class CapacityDashboardService {

    public CapacityDashboardResponse getDashboard() {

        CapacityDashboardResponse response = new CapacityDashboardResponse();

        response.setCurrentLoad(67.4);
        response.setMaximumCapacity(100.0);

        response.setCpuTrend(Arrays.asList(
                35.2,
                42.8,
                51.4,
                58.6,
                63.7,
                67.4
        ));

        response.setMemoryTrend(Arrays.asList(
                40.5,
                45.9,
                48.7,
                52.3,
                55.1,
                57.8
        ));

        response.setStorageGrowth(Arrays.asList(
                120.5,
                128.3,
                136.9,
                145.4,
                152.8,
                160.6
        ));

        response.setKafkaLag(84);

        if (response.getCurrentLoad() >= 90) {
            response.setCapacityStatus("CRITICAL");
        } else if (response.getCurrentLoad() >= 75) {
            response.setCapacityStatus("WARNING");
        } else {
            response.setCapacityStatus("HEALTHY");
        }

        response.setTimestamp(LocalDateTime.now().toString());

        return response;
    }
}