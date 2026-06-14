package com.rapido.rideservice.geospatial;

import com.rapido.rideservice.entity.Driver;
import com.rapido.rideservice.repository.DriverRepository;
import com.rapido.rideservice.util.DistanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class GeoSpatialService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DistanceUtil distanceUtil;

    public List<Driver> findNearbyDrivers(double lat, double lng, double radiusMeters) {

        double radiusKm = radiusMeters / 1000.0;

        List<Driver> drivers = driverRepository.findAll();

        System.out.println("TOTAL DRIVERS FROM DB = " + drivers.size());

        return drivers.stream()
                .filter(driver -> Boolean.TRUE.equals(driver.getActive()))
                .filter(driver -> Boolean.TRUE.equals(driver.getAvailable()))
                .filter(driver -> driver.getLatitude() != null && driver.getLongitude() != null)
                .filter(driver -> distanceUtil.calculateDistance(
                        lat,
                        lng,
                        driver.getLatitude(),
                        driver.getLongitude()
                ) <= radiusKm)
                .sorted(Comparator.comparingDouble(driver ->
                        distanceUtil.calculateDistance(
                                lat,
                                lng,
                                driver.getLatitude(),
                                driver.getLongitude()
                        )
                ))
                .toList();
    }
}