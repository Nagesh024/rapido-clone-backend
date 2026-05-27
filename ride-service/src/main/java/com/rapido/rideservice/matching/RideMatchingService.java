package com.rapido.rideservice.matching;

import com.rapido.rideservice.dto.RideRequestDTO;
import com.rapido.rideservice.dto.RideResponseDTO;
import com.rapido.rideservice.entity.Driver;
import com.rapido.rideservice.geospatial.GeoSpatialService;
import com.rapido.rideservice.repository.DriverRepository;
import com.rapido.rideservice.scoring.DriverScoringService;
import com.rapido.rideservice.surge.SurgePricingService;
import com.rapido.rideservice.traffic.TrafficEtaService;
import com.rapido.rideservice.util.DistanceUtil;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RideMatchingService {

    @Autowired
    private GeoSpatialService geoSpatialService;

    @Autowired
    private DriverScoringService scoringService;

    @Autowired
    private SurgePricingService surgePricingService;

    @Autowired
    private TrafficEtaService trafficEtaService;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DistanceUtil distanceUtil;

    @Transactional
    public RideResponseDTO requestRide(RideRequestDTO request) {

        List<Driver> nearbyDrivers =
                geoSpatialService.findNearbyDrivers(
                        request.getPickupLatitude(),
                        request.getPickupLongitude(),
                        5000
                );

        if (nearbyDrivers.isEmpty()) {
            throw new RuntimeException("No drivers available nearby");
        }

        Driver bestDriver = nearbyDrivers.stream()
                .max(Comparator.comparing(driver -> {

                    double distanceKm =
                            distanceUtil.calculateDistance(
                                    request.getPickupLatitude(),
                                    request.getPickupLongitude(),
                                    driver.getLatitude(),
                                    driver.getLongitude()
                            );

                    return scoringService.calculateScore(
                            driver,
                            distanceKm
                    );
                }))
                .orElseThrow();

        Driver lockedDriver =
                driverRepository.lockDriverById(bestDriver.getId())
                        .orElseThrow(() ->
                                new RuntimeException("Driver not found"));

        if (!lockedDriver.getAvailable()) {
            throw new RuntimeException("Driver already allocated");
        }

        lockedDriver.setAvailable(false);

        lockedDriver.setCurrentLoad(
                lockedDriver.getCurrentLoad() + 1
        );

        driverRepository.save(lockedDriver);

        double distanceKm =
                distanceUtil.calculateDistance(
                        request.getPickupLatitude(),
                        request.getPickupLongitude(),
                        lockedDriver.getLatitude(),
                        lockedDriver.getLongitude()
                );

        double driverScore =
                scoringService.calculateScore(
                        lockedDriver,
                        distanceKm
                );

        double surgeMultiplier =
                surgePricingService.calculateSurgeMultiplier(
                        nearbyDrivers.size(),
                        5
                );

        double estimatedFare =
                surgePricingService.calculateFare(
                        100,
                        surgeMultiplier
                );

        double etaMinutes =
                trafficEtaService.calculateEtaMinutes(
                        distanceKm
                );

        RideResponseDTO response =
                new RideResponseDTO();

        response.setMessage("Driver matched successfully");

        response.setDriverId(lockedDriver.getId());
        response.setEstimatedDistance(distanceKm);
        response.setDriverScore(driverScore);
        response.setSurgeMultiplier(surgeMultiplier);
        response.setEstimatedFare(estimatedFare);
        response.setEstimatedEtaMinutes(etaMinutes);

        return response;
    }

    public List<Driver> nearbyDrivers(
            double lat,
            double lng
    ) {

        return geoSpatialService.findNearbyDrivers(
                lat,
                lng,
                5000
        );
    }

    public double surgePreview(
            double lat,
            double lng
    ) {

        int nearbyDrivers =
                geoSpatialService.findNearbyDrivers(
                        lat,
                        lng,
                        5000
                ).size();

        return surgePricingService.calculateSurgeMultiplier(
                nearbyDrivers,
                5
        );
    }
}