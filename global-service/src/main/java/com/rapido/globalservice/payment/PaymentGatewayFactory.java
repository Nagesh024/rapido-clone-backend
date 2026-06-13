package com.rapido.globalservice.payment;

import org.springframework.stereotype.Component;

@Component
public class PaymentGatewayFactory {

    private final RazorpayGateway razorpayGateway;

    private final StripeGateway stripeGateway;

    public PaymentGatewayFactory(
            RazorpayGateway razorpayGateway,
            StripeGateway stripeGateway
    ) {
        this.razorpayGateway = razorpayGateway;
        this.stripeGateway = stripeGateway;
    }

    public PaymentGateway get(
            String countryCode
    ) {

        switch (countryCode.toUpperCase()) {

            case "IN":
                return razorpayGateway;

            case "AE":
                return stripeGateway;

            default:
                throw new RuntimeException(
                        "No payment gateway configured for country: "
                                + countryCode
                );
        }
    }
}