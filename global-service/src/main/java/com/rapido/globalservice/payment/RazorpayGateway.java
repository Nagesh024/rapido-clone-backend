package com.rapido.globalservice.payment;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RazorpayGateway
        implements PaymentGateway {

    @Override
    public String processPayment(
            BigDecimal amount,
            String currency
    ) {

        return "Payment processed via Razorpay. Amount="
                + amount
                + " "
                + currency;
    }
}