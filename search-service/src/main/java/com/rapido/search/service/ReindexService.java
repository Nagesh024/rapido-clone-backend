package com.rapido.search.service;

import com.rapido.search.model.LocationDocument;
import com.rapido.search.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReindexService {

    private final LocationRepository repository;

    public ReindexService(LocationRepository repository) {
        this.repository = repository;
    }

    public String rebuildIndex() {

        try {
            repository.deleteAll();
        } catch (Exception e) {
            System.out.println("Locations index not found. Creating new index...");
        }

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

        return "Reindex Completed";
    }
}