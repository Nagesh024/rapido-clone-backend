package com.rapido.globalservice.payment;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StripeGateway
        implements PaymentGateway {

    @Override
    public String processPayment(
            BigDecimal amount,
            String currency
    ) {

        return "Payment processed via Stripe. Amount="
                + amount
                + " "
                + currency;
    }
}