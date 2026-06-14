package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.dto.HeatmapResponse;
import com.rapido.analyticsservice.repository.FactRideRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeatmapService {

    private final FactRideRepository factRideRepository;

    public HeatmapService(
            FactRideRepository factRideRepository) {

        this.factRideRepository =
                factRideRepository;
    }

    public List<HeatmapResponse> getHeatmapData() {

        List<HeatmapResponse> result =
                new ArrayList<>();

        HeatmapResponse point =
                new HeatmapResponse();

        point.setLatitude(
                17.3850);

        point.setLongitude(
                78.4867);

        point.setRideCount(
                factRideRepository.count());

        result.add(point);

        return result;
    }
}