package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.entity.FactRide;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FactRideService {

    private final FactRideRepository factRideRepository;

    public FactRideService(
            FactRideRepository factRideRepository) {

        this.factRideRepository =
                factRideRepository;
    }

    @Transactional
    public FactRide save(
            FactRide factRide) {

        return factRideRepository.save(
                factRide);
    }
}