package com.rapido.driverservice.service;

import com.rapido.driverservice.entity.Driver;
import com.rapido.driverservice.repository.DriverRepository;
import com.rapido.driverservice.util.DistanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DriverSearchService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> findNearbyDrivers(Double latitude,
                                           Double longitude,
                                           Double radius,
                                           String vehicleType) {

        List<Driver> availableDrivers =
                driverRepository.findByVehicleTypeAndStatus(vehicleType, "AVAILABLE");

        return availableDrivers.stream()
                .map(driver -> {
                    double distance = DistanceUtil.calculateDistance(
                            latitude,
                            longitude,
                            driver.getLatitude(),
                            driver.getLongitude()
                    );

                    return new DriverDistance(driver, distance);
                })
                .filter(dd -> dd.distance <= radius)
                .sorted(Comparator.comparingDouble(dd -> dd.distance))
                .map(dd -> dd.driver)
                .toList();
    }

    // internal helper class
    private static class DriverDistance {
        Driver driver;
        double distance;

        DriverDistance(Driver driver, double distance) {
            this.driver = driver;
            this.distance = distance;
        }
    }
}