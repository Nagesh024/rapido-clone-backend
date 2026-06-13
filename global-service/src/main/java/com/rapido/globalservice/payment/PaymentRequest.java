package com.rapido.globalservice.payment;

import java.math.BigDecimal;

public class PaymentRequest {

    private String countryCode;

    private BigDecimal amount;

    private String currency;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(
            String countryCode
    ) {
        this.countryCode = countryCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(
            BigDecimal amount
    ) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(
            String currency
    ) {
        this.currency = currency;
    }
}