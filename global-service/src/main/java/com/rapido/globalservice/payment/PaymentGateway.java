package com.rapido.globalservice.payment;

import java.math.BigDecimal;

public interface PaymentGateway {

    String processPayment(
            BigDecimal amount,
            String currency
    );
}