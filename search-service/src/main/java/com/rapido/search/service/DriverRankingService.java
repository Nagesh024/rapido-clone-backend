package com.rapido.search.service;

import com.rapido.search.model.DriverDocument;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DriverRankingService {

    public List<DriverDocument> rankDrivers(
            List<DriverDocument> drivers) {

        return drivers.stream()
                .sorted(
                        Comparator
                                .comparingDouble(
                                        DriverDocument::getRating
                                )
                                .reversed()
                )
                .toList();
    }
}