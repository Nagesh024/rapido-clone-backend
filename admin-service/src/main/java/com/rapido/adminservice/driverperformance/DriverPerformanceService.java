package com.rapido.adminservice.driverperformance;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DriverPerformanceService {

    public Double calculateScore(Double acceptanceRate,
                                 Double completionRate,
                                 Double customerRating) {

        return (acceptanceRate * 0.3)
                + (completionRate * 0.4)
                + (customerRating * 0.3);
    }

    public List<DriverLeaderboardResponse> getTopPerformingDrivers(String region) {

        List<DriverLeaderboardResponse> drivers = new ArrayList<>();

        drivers.add(new DriverLeaderboardResponse(101L, "Rahul", 95.5, "Hyderabad"));
        drivers.add(new DriverLeaderboardResponse(102L, "Kiran", 92.0, "Hyderabad"));
        drivers.add(new DriverLeaderboardResponse(103L, "Anil", 88.5, "Bangalore"));

        if (region == null || region.isEmpty()) {
            return drivers;
        }

        return drivers.stream()
                .filter(driver -> driver.getRegion().equalsIgnoreCase(region))
                .toList();
    }
}