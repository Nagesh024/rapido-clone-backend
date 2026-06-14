package com.rapido.paymentservice.repository;

import com.rapido.paymentservice.entity.PaymentStatus;
import com.rapido.paymentservice.entity.PaymentTransaction;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {

    boolean existsByRideIdAndStatus(Long rideId, PaymentStatus status);

    Optional<PaymentTransaction> findByRideIdAndStatus(Long rideId, PaymentStatus status);

    Page<PaymentTransaction> findByPayerId(Long payerId, Pageable pageable);

    Page<PaymentTransaction> findByPayerIdAndStatus(Long payerId, PaymentStatus status, Pageable pageable);
}