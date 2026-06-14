package com.rapido.search.config;

import com.rapido.search.model.RideHistoryDocument;
import com.rapido.search.repository.RideHistoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class RideHistoryDataLoader {

    private final RideHistoryRepository repository;

    public RideHistoryDataLoader(
            RideHistoryRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void load() {

        if(repository.count() > 0)
            return;

        RideHistoryDocument ride =
                new RideHistoryDocument();

        ride.setId("1");
        ride.setUserId(101L);
        ride.setPickup("Madhapur");
        ride.setDestination("Airport");
        ride.setRideType("Bike");

        repository.save(ride);

        System.out.println(
                "RIDE HISTORY INDEXED"
        );
    }
}