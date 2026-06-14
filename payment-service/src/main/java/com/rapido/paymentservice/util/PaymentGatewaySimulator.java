package com.rapido.paymentservice.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PaymentGatewaySimulator {

    private final Random random = new Random();

    public boolean processPayment() {
        return random.nextInt(100) < 90;
    }
}