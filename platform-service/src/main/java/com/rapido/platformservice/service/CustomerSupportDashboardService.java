package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.CustomerSupportDashboardResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerSupportDashboardService {

    public CustomerSupportDashboardResponse getDashboard() {

        CustomerSupportDashboardResponse response =
                new CustomerSupportDashboardResponse();

        response.setOpenTickets(148);
        response.setAverageResolutionTime(3.45);
        response.setEscalations(9);
        response.setRideComplaints(27);
        response.setRefundRequests(18);

        if(response.getOpenTickets() < 200 &&
           response.getEscalations() < 15){
            response.setSupportStatus("HEALTHY");
        }
        else if(response.getOpenTickets() < 400){
            response.setSupportStatus("WARNING");
        }
        else{
            response.setSupportStatus("CRITICAL");
        }

        return response;
    }
}