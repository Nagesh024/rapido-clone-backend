package com.rapido.paymentservice.controller;

import com.rapido.paymentservice.entity.PaymentStatus;
import com.rapido.paymentservice.service.PaymentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Payment Service Running Successfully");
    }

    @PostMapping("/wallet/create")
    public ResponseEntity<?> createWallet(@RequestParam Long userId) {
        return ResponseEntity.ok(paymentService.createWallet(userId));
    }

    @PostMapping("/wallet/topup")
    public ResponseEntity<?> topUpWallet(
            @RequestParam Long userId,
            @RequestParam Double amount
    ) {
        return ResponseEntity.ok(paymentService.topUpWallet(userId, amount));
    }

    @GetMapping("/wallet/balance")
    public ResponseEntity<?> getBalance(@RequestParam Long userId) {
        return ResponseEntity.ok(paymentService.getBalance(userId));
    }

    @PostMapping("/payment/pay")
    public ResponseEntity<?> payForRide(
            @RequestParam Long userId,
            @RequestParam Long rideId
    ) {
        return ResponseEntity.ok(paymentService.processRidePayment(userId, rideId));
    }

    @PostMapping("/payment/refund")
    public ResponseEntity<?> refundRide(@RequestParam Long rideId) {
        return ResponseEntity.ok(paymentService.refundRide(rideId));
    }

    @GetMapping("/transactions/history")
    public ResponseEntity<?> history(
            @RequestParam Long userId,
            @RequestParam(required = false) PaymentStatus status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(
                paymentService.getTransactionHistory(userId, status, page, size)
        );
    }
}