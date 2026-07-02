package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.AiPredictionDashboardResponse;
import org.springframework.stereotype.Service;

@Service
public class AiPredictionDashboardService {

    public AiPredictionDashboardResponse getPredictionDashboard() {

        AiPredictionDashboardResponse response =
                new AiPredictionDashboardResponse();

        response.setDemandForecast(18750);
        response.setSurgeForecast(1.85);
        response.setDriverShortage(165);
        response.setRevenuePrediction(3254875.50);

        if(response.getDemandForecast() > 15000 &&
                response.getDriverShortage() > 100){
            response.setPredictionStatus("HIGH DEMAND EXPECTED");
        }
        else{
            response.setPredictionStatus("NORMAL");
        }

        return response;
    }
}
