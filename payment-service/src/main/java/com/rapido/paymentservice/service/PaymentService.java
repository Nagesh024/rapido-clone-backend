package com.rapido.paymentservice.service;

import com.rapido.paymentservice.dto.PaymentResponse;
import com.rapido.paymentservice.entity.DriverEarnings;
import com.rapido.paymentservice.entity.PaymentStatus;
import com.rapido.paymentservice.entity.PaymentTransaction;
import com.rapido.paymentservice.entity.Wallet;
import com.rapido.paymentservice.exception.PaymentException;
import com.rapido.paymentservice.repository.DriverEarningsRepository;
import com.rapido.paymentservice.repository.PaymentTransactionRepository;
import com.rapido.paymentservice.repository.WalletRepository;
import com.rapido.paymentservice.util.PaymentGatewaySimulator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public PaymentService(WalletRepository walletRepository,
                          PaymentTransactionRepository transactionRepository,
                          DriverEarningsRepository driverEarningsRepository,
                          PaymentGatewaySimulator paymentGatewaySimulator) {

        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
        this.driverEarningsRepository = driverEarningsRepository;
        this.paymentGatewaySimulator = paymentGatewaySimulator;
    }

    public Wallet createWallet(Long userId) {

        if (walletRepository.findByUserId(userId).isPresent()) {
            return walletRepository.findByUserId(userId).get();
        }

        Wallet wallet = new Wallet();
        wallet.setUserId(userId);
        wallet.setBalance(0.0);
        wallet.setActive(true);

        return walletRepository.save(wallet);
    }

    @Transactional
    public String topUpWallet(Long userId, Double amount) {

        if (amount == null || amount < 100) {
            throw new PaymentException("Minimum top-up amount is 100");
        }

        Wallet wallet = walletRepository.findByUserIdForUpdate(userId)
                .orElseGet(() -> createWallet(userId));

        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);

        return "Wallet Recharged Successfully";
    }

    public Double getBalance(Long userId) {

        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new PaymentException("Wallet not found"));

        return wallet.getBalance();
    }

    @Transactional
    public PaymentResponse processRidePayment(Long userId, Long rideId) {

        if (transactionRepository.existsByRideIdAndStatus(rideId, PaymentStatus.SUCCESS)) {
            throw new PaymentException("Payment already completed for this ride");
        }

        Double fare = fetchRideFare(rideId);
        Long driverId = fetchDriverIdForRide(rideId);

        Wallet riderWallet = walletRepository.findByUserIdForUpdate(userId)
                .orElseThrow(() -> new PaymentException("Wallet not found"));

        if (riderWallet.getBalance() < fare) {
            saveTransaction(rideId, userId, driverId, fare, PaymentStatus.FAILED);
            throw new PaymentException("Insufficient wallet balance");
        }

        boolean gatewaySuccess = paymentGatewaySimulator.processPayment();

        if (!gatewaySuccess) {
            saveTransaction(rideId, userId, driverId, fare, PaymentStatus.FAILED);
            throw new PaymentException("Payment gateway failed. Try again.");
        }

        riderWallet.setBalance(riderWallet.getBalance() - fare);
        walletRepository.save(riderWallet);

        DriverEarnings earnings = driverEarningsRepository.findByDriverId(driverId)
                .orElse(new DriverEarnings());

        if (earnings.getDriverId() == null) {
            earnings.setDriverId(driverId);
            earnings.setTotalEarnings(0.0);
        }

        earnings.setTotalEarnings(earnings.getTotalEarnings() + fare);
        driverEarningsRepository.save(earnings);

        PaymentTransaction transaction = saveTransaction(
                rideId,
                userId,
                driverId,
                fare,
                PaymentStatus.SUCCESS
        );

        PaymentResponse response = new PaymentResponse();
        response.setRideId(rideId);
        response.setPayerId(userId);
        response.setDriverId(driverId);
        response.setAmount(fare);
        response.setStatus(PaymentStatus.SUCCESS.name());
        response.setMessage("Payment Successful");
        response.setTransactionReference(transaction.getTransactionReference());

        return response;
    }

    @Transactional
    public String refundRide(Long rideId) {

        PaymentTransaction transaction = transactionRepository
                .findByRideIdAndStatus(rideId, PaymentStatus.SUCCESS)
                .orElseThrow(() -> new PaymentException("Successful payment not found"));

        Wallet wallet = walletRepository.findByUserIdForUpdate(transaction.getPayerId())
                .orElseThrow(() -> new PaymentException("Wallet not found"));

        wallet.setBalance(wallet.getBalance() + transaction.getAmount());
        walletRepository.save(wallet);

        DriverEarnings earnings = driverEarningsRepository
                .findByDriverId(transaction.getDriverId())
                .orElseThrow(() -> new PaymentException("Driver earnings not found"));

        earnings.setTotalEarnings(earnings.getTotalEarnings() - transaction.getAmount());
        driverEarningsRepository.save(earnings);

        transaction.setStatus(PaymentStatus.REFUNDED);
        transactionRepository.save(transaction);

        return "Refund Processed Successfully";
    }

    public Page<PaymentTransaction> getTransactionHistory(
            Long userId,
            PaymentStatus status,
            int page,
            int size
    ) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("createdAt").descending()
        );

        if (status == null) {
            return transactionRepository.findByPayerId(userId, pageable);
        }

        return transactionRepository.findByPayerIdAndStatus(userId, status, pageable);
    }

    private PaymentTransaction saveTransaction(
            Long rideId,
            Long payerId,
            Long driverId,
            Double amount,
            PaymentStatus status
    ) {

        PaymentTransaction transaction = new PaymentTransaction();

        transaction.setRideId(rideId);
        transaction.setPayerId(payerId);
        transaction.setDriverId(driverId);
        transaction.setAmount(amount);
        transaction.setStatus(status);
        transaction.setTransactionReference(UUID.randomUUID().toString());
        transaction.setCreatedAt(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }

    private Double fetchRideFare(Long rideId) {
        return 250.0;
    }

    private Long fetchDriverIdForRide(Long rideId) {
        return 101L;
    }
}