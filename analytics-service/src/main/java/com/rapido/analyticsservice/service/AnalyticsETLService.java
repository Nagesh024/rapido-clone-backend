package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.RideCompletedEvent;
import com.rapido.analyticsservice.entity.FactRide;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnalyticsETLService {

    private static final Logger log =
            LoggerFactory.getLogger(
                    AnalyticsETLService.class);

    private final FactRideRepository factRideRepository;

    public AnalyticsETLService(
            FactRideRepository factRideRepository) {

        this.factRideRepository =
                factRideRepository;
    }

    public void processRideEvent(
            RideCompletedEvent event) {

        validate(event);

        if (factRideRepository
                .existsByRideId(
                        event.getRideId())) {

            log.warn(
                    "Duplicate Ride Event: {}",
                    event.getRideId());

            return;
        }

        FactRide factRide = new FactRide();

        factRide.setRideId(
                event.getRideId());

        factRide.setFare(
                event.getFare());

        factRide.setDistance(
                event.getDistance());

        factRide.setDurationMinutes(
                event.getDurationMinutes());

        factRide.setStatus(
                event.getStatus());

        factRide.setCreatedAt(
                LocalDateTime.now());

        factRideRepository.save(
                factRide);

        log.info(
                "Ride Loaded Into Warehouse: {}",
                event.getRideId());
    }

    private void validate(
            RideCompletedEvent event) {

        if (event.getRideId() == null) {

            throw new RuntimeException(
                    "RideId Missing");
        }

        if (event.getFare() == null) {

            throw new RuntimeException(
                    "Fare Missing");
        }

        if (event.getFare()
                .doubleValue() < 0) {

            throw new RuntimeException(
                    "Invalid Fare");
        }
    }
}