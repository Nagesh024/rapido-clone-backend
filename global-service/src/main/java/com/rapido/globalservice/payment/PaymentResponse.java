package com.rapido.globalservice.payment;

public class PaymentResponse {

    private String gateway;

    private String message;

    public PaymentResponse() {
    }

    public PaymentResponse(
            String gateway,
            String message
    ) {
        this.gateway = gateway;
        this.message = message;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(
            String gateway
    ) {
        this.gateway = gateway;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(
            String message
    ) {
        this.message = message;
    }
}