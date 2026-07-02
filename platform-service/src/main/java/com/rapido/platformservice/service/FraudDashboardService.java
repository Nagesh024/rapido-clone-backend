package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.FraudDashboardResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FraudDashboardService {

    public FraudDashboardResponse getDashboard() {

        FraudDashboardResponse response = new FraudDashboardResponse();

        response.setHighRiskUsers(Arrays.asList(
                "USR-10045",
                "USR-10328",
                "USR-10477"
        ));

        response.setHighRiskDrivers(Arrays.asList(
                "DRV-20011",
                "DRV-20078"
        ));

        response.setPaymentFraud(Arrays.asList(
                "PAY-90012",
                "PAY-90045"
        ));

        response.setWalletAbuse(Arrays.asList(
                "WALLET-3012",
                "WALLET-4418"
        ));

        response.setPromoAbuse(Arrays.asList(
                "PROMO-NEW100",
                "PROMO-RIDE50"
        ));

        response.setTotalFraudCases(11);

        response.setInvestigationStatus("UNDER_INVESTIGATION");

        return response;
    }
}