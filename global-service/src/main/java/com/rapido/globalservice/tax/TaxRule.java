package com.rapido.globalservice.tax;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(
        name = "tax_rules",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_country_tax_type",
                        columnNames = {
                                "country_code",
                                "tax_type"
                        }
                )
        }
)
public class TaxRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "country_code",
            nullable = false,
            length = 10
    )
    private String countryCode;

    @Column(
            name = "tax_type",
            nullable = false,
            length = 50
    )
    private String taxType;

    @Column(
            nullable = false,
            precision = 10,
            scale = 2
    )
    private BigDecimal percentage;

    public TaxRule() {
    }

    public Long getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }
}