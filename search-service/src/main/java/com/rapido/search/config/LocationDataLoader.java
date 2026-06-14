package com.rapido.search.config;

import com.rapido.search.model.LocationDocument;
import com.rapido.search.repository.LocationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class LocationDataLoader {

    private final LocationRepository repository;

    public LocationDataLoader(LocationRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void loadLocations() {

        if(repository.count() > 0)
            return;

        LocationDocument airport = new LocationDocument();
        airport.setId("1");
        airport.setName("Rajiv Gandhi International Airport");
        airport.setType("AIRPORT");
        airport.setCity("Hyderabad");

        LocationDocument railway = new LocationDocument();
        railway.setId("2");
        railway.setName("Secunderabad Railway Station");
        railway.setType("RAILWAY");
        railway.setCity("Hyderabad");

        LocationDocument mall = new LocationDocument();
        mall.setId("3");
        mall.setName("Inorbit Mall");
        mall.setType("MALL");
        mall.setCity("Hyderabad");

        LocationDocument landmark = new LocationDocument();
        landmark.setId("4");
        landmark.setName("Charminar");
        landmark.setType("LANDMARK");
        landmark.setCity("Hyderabad");

        repository.save(airport);
        repository.save(railway);
        repository.save(mall);
        repository.save(landmark);

        System.out.println("LOCATIONS INDEXED");
    }
}