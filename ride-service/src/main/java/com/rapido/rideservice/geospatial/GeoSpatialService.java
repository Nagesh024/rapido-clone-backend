package com.rapido.rideservice.geospatial;

import com.rapido.rideservice.entity.Driver;
import com.rapido.rideservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class GeoSpatialService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> findNearbyDrivers(double lat, double lng, double radiusMeters) {

        List<Driver> drivers = driverRepository.findAll();

        System.out.println("TOTAL DRIVERS FROM DB = " + drivers.size());

        return drivers.stream()
                .filter(driver -> Boolean.TRUE.equals(driver.getActive()))
                .filter(driver -> Boolean.TRUE.equals(driver.getAvailable()))
                .filter(driver -> driver.getLatitude() != null && driver.getLongitude() != null)
                .sorted(Comparator.comparingDouble(driver ->
                        Math.pow(driver.getLatitude() - lat, 2)
                                + Math.pow(driver.getLongitude() - lng, 2)
                ))
                .toList();
    }
}