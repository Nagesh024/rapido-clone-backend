package com.rapido.globalservice.ride;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            precision = 19,
            scale = 2,
            nullable = false
    )
    private BigDecimal fare;

    @Column(
            precision = 19,
            scale = 2,
            nullable = false
    )
    private BigDecimal tax;

    @Column(
            precision = 19,
            scale = 2,
            nullable = false
    )
    private BigDecimal totalAmount;

    public Ride() {
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(
            BigDecimal totalAmount
    ) {
        this.totalAmount = totalAmount;
    }
}