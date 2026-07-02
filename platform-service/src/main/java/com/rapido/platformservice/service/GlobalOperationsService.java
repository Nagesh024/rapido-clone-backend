package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.GlobalOperationsResponse;
import org.springframework.stereotype.Service;

@Service
public class GlobalOperationsService {

    public GlobalOperationsResponse getDashboard() {

        GlobalOperationsResponse response =
                new GlobalOperationsResponse();

        response.setRegion("Asia-Pacific");

        response.setCountry("India");

        response.setRegionHealth("HEALTHY");

        response.setCountryRevenue(15875000.50);

        response.setCountryDemand(48250);

        response.setCountryIncidents(3);

        if(response.getCountryIncidents() == 0){
            response.setOverallStatus("EXCELLENT");
        }
        else if(response.getCountryIncidents() <= 5){
            response.setOverallStatus("HEALTHY");
        }
        else{
            response.setOverallStatus("WARNING");
        }

        return response;
    }
}