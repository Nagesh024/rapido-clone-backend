package com.rapido.rideservice.geospatial;

import com.rapido.rideservice.entity.Driver;
import com.rapido.rideservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoSpatialService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> findNearbyDrivers(
            double lat,
            double lng,
            double radiusMeters
    ) {

        return driverRepository.findNearbyDrivers(
                lat,
                lng,
                radiusMeters
        );
    }
}