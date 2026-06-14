package com.rapido.rideservice.optimization;

import com.rapido.rideservice.entity.Driver;
import com.rapido.rideservice.entity.Ride;
import com.rapido.rideservice.entity.RideStatus;
import com.rapido.rideservice.repository.DriverRepository;
import com.rapido.rideservice.repository.RideRepository;
import com.rapido.rideservice.geospatial.GeoSpatialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RideReassignmentService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private GeoSpatialService geoSpatialService;

    public void reassignRide(Ride ride) {

        if (ride.getDriverId() != null) {
            driverRepository.findById(ride.getDriverId()).ifPresent(oldDriver -> {
                oldDriver.setAvailable(true);
                oldDriver.setCurrentLoad(Math.max(0, oldDriver.getCurrentLoad() - 1));
                driverRepository.save(oldDriver);
            });
        }

        List<Driver> nearbyDrivers = geoSpatialService.findNearbyDrivers(
                ride.getPickupLatitude(),
                ride.getPickupLongitude(),
                5000
        );

        if (nearbyDrivers.isEmpty()) {
            ride.setStatus(RideStatus.CANCELLED);
            rideRepository.save(ride);
            return;
        }

        Driver newDriver = nearbyDrivers.get(0);

        newDriver.setAvailable(false);
        newDriver.setCurrentLoad(newDriver.getCurrentLoad() + 1);
        driverRepository.save(newDriver);

        ride.setDriverId(newDriver.getId());
        ride.setStatus(RideStatus.REQUESTED);
        ride.setRequestedAt(LocalDateTime.now());

        rideRepository.save(ride);
    }
}