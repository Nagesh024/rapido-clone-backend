package com.rapido.search.config;

import com.rapido.search.model.DriverDocument;
import com.rapido.search.repository.DriverSearchRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Component
public class DataLoader {

    private final DriverSearchRepository repository;

    public DataLoader(
            DriverSearchRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void loadData() {

        if(repository.count() > 1)
            return;

        DriverDocument d1 = new DriverDocument();
        d1.setDriverId("1002");
        d1.setRating(4.9);
        d1.setStatus("AVAILABLE");
        d1.setLocation(
                new GeoPoint(17.401,78.501)
        );

        DriverDocument d2 = new DriverDocument();
        d2.setDriverId("1003");
        d2.setRating(4.5);
        d2.setStatus("AVAILABLE");
        d2.setLocation(
                new GeoPoint(17.402,78.502)
        );

        repository.save(d1);
        repository.save(d2);
    }
}