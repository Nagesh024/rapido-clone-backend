package com.rapido.globalservice.payment;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(
            PaymentService service
    ) {
        this.service = service;
    }

    @PostMapping
    public PaymentResponse process(
            @RequestBody PaymentRequest request
    ) {

        return service.process(
                request
        );
    }
}