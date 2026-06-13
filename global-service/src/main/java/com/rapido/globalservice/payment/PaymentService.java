package com.rapido.globalservice.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentGatewayFactory factory;

    public PaymentService(
            PaymentGatewayFactory factory
    ) {
        this.factory = factory;
    }

    public PaymentResponse process(
            PaymentRequest request
    ) {

        PaymentGateway gateway =
                factory.get(
                        request.getCountryCode()
                );

        String result =
                gateway.processPayment(
                        request.getAmount(),
                        request.getCurrency()
                );

        return new PaymentResponse(
                gateway.getClass().getSimpleName(),
                result
        );
    }
}