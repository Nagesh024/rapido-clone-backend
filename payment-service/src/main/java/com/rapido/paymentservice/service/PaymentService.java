package com.rapido.paymentservice.service;

import com.rapido.paymentservice.dto.PaymentResponse;
import com.rapido.paymentservice.entity.*;
import com.rapido.paymentservice.exception.PaymentException;
import com.rapido.paymentservice.repository.*;
import com.rapido.paymentservice.util.PaymentGatewaySimulator;
import com.rapido.paymentservice.producer.PaymentEventProducer;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    private final WalletRepository walletRepository;
    private final PaymentTransactionRepository transactionRepository;
    private final DriverEarningsRepository driverEarningsRepository;
    private final PaymentGatewaySimulator paymentGatewaySimulator;
    private final PaymentEventProducer paymentEventProducer;

    public PaymentService(
            WalletRepository walletRepository,
            PaymentTransactionRepository transactionRepository,
            DriverEarningsRepository driverEarningsRepository,
            PaymentGatewaySimulator paymentGatewaySimulator,
            PaymentEventProducer paymentEventProducer
    ) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
        this.driverEarningsRepository = driverEarningsRepository;
        this.paymentGatewaySimulator = paymentGatewaySimulator;
        this.paymentEventProducer = paymentEventProducer;
    }

    // =========================
    // WALLET
    // =========================

    public Wallet createWallet(Long userId) {

        return walletRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Wallet wallet = new Wallet();
                    wallet.setUserId(userId);
                    wallet.setBalance(0.0);
                    wallet.setActive(true);
                    return walletRepository.save(wallet);
                });
    }

    @Transactional
    public String topUpWallet(Long userId, Double amount) {

        if (amount == null || amount < 100) {
            throw new PaymentException("Minimum top-up is 100");
        }

        Wallet wallet = walletRepository.findByUserIdForUpdate(userId)
                .orElseGet(() -> createWallet(userId));

        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);

        return "Wallet Updated Successfully";
    }

    public Double getBalance(Long userId) {

        return walletRepository.findByUserId(userId)
                .orElseThrow(() -> new PaymentException("Wallet not found"))
                .getBalance();
    }

    // =========================
    // PAYMENT CORE (SAGA START POINT)
    // =========================

    @Transactional
    public PaymentResponse processRidePayment(Long userId, Long rideId) {

        if (transactionRepository.existsByRideIdAndStatus(rideId, PaymentStatus.SUCCESS)) {
            throw new PaymentException("Payment already done");
        }

        Double fare = fetchRideFare(rideId);
        Long driverId = fetchDriverIdForRide(rideId);

        Wallet wallet = walletRepository.findByUserIdForUpdate(userId)
                .orElseThrow(() -> new PaymentException("Wallet not found"));

        if (wallet.getBalance() < fare) {
            saveTransaction(rideId, userId, driverId, fare, PaymentStatus.FAILED);
            throw new PaymentException("Insufficient balance");
        }

       
        if (!paymentGatewaySimulator.processPayment()) {

            saveTransaction(rideId, userId, driverId, fare, PaymentStatus.FAILED);

            // 🔥 SAGA COMPENSATION EVENT
            paymentEventProducer.publishPaymentFailedEvent(
                    rideId.toString(),
                    driverId.toString()
            );

            throw new PaymentException("Gateway failed - Saga compensation triggered");
        }

        wallet.setBalance(wallet.getBalance() - fare);
        walletRepository.save(wallet);

        DriverEarnings earnings = driverEarningsRepository.findByDriverId(driverId)
                .orElse(new DriverEarnings());

        if (earnings.getDriverId() == null) {
            earnings.setDriverId(driverId);
            earnings.setTotalEarnings(0.0);
        }

        earnings.setTotalEarnings(earnings.getTotalEarnings() + fare);
        driverEarningsRepository.save(earnings);

        PaymentTransaction tx = saveTransaction(
                rideId, userId, driverId, fare, PaymentStatus.SUCCESS
        );

        return buildResponse(tx, fare);
    }

    
    @Transactional
    public String refundRide(Long rideId) {

        PaymentTransaction tx = transactionRepository
                .findByRideIdAndStatus(rideId, PaymentStatus.SUCCESS)
                .orElseThrow(() -> new PaymentException("No payment found"));

        Wallet wallet = walletRepository.findByUserIdForUpdate(tx.getPayerId())
                .orElseThrow(() -> new PaymentException("Wallet not found"));

        wallet.setBalance(wallet.getBalance() + tx.getAmount());
        walletRepository.save(wallet);

        DriverEarnings earnings = driverEarningsRepository.findByDriverId(tx.getDriverId())
                .orElseThrow(() -> new PaymentException("Driver earnings not found"));

        earnings.setTotalEarnings(earnings.getTotalEarnings() - tx.getAmount());
        driverEarningsRepository.save(earnings);

        tx.setStatus(PaymentStatus.REFUNDED);
        transactionRepository.save(tx);

        return "Refund Successful";
    }

   
    public Page<PaymentTransaction> getTransactionHistory(
            Long userId,
            PaymentStatus status,
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        return (status == null)
                ? transactionRepository.findByPayerId(userId, pageable)
                : transactionRepository.findByPayerIdAndStatus(userId, status, pageable);
    }

    private PaymentTransaction saveTransaction(
            Long rideId,
            Long payerId,
            Long driverId,
            Double amount,
            PaymentStatus status
    ) {

        PaymentTransaction tx = new PaymentTransaction();
        tx.setRideId(rideId);
        tx.setPayerId(payerId);
        tx.setDriverId(driverId);
        tx.setAmount(amount);
        tx.setStatus(status);
        tx.setTransactionReference(UUID.randomUUID().toString());
        tx.setCreatedAt(LocalDateTime.now());

        return transactionRepository.save(tx);
    }

    private PaymentResponse buildResponse(PaymentTransaction tx, Double fare) {

        PaymentResponse res = new PaymentResponse();
        res.setRideId(tx.getRideId());
        res.setPayerId(tx.getPayerId());
        res.setDriverId(tx.getDriverId());
        res.setAmount(fare);
        res.setStatus(tx.getStatus().name());
        res.setMessage("Payment Successful");
        res.setTransactionReference(tx.getTransactionReference());

        return res;
    }

    private Double fetchRideFare(Long rideId) {
        return 250.0;
    }

    private Long fetchDriverIdForRide(Long rideId) {
        return 101L;
    }
}