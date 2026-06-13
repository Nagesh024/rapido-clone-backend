package com.rapido.globalservice.currency;

import jakarta.persistence.*;

@Entity
@Table(
        name = "currencies",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_currency_code",
                        columnNames = "code"
                )
        }
)
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            length = 10,
            unique = true
    )
    private String code;

    @Column(
            nullable = false,
            length = 10
    )
    private String symbol;

    @Column(
            name = "decimal_places",
            nullable = false
    )
    private Integer decimalPlaces;

    @Column(nullable = false)
    private Boolean active;

    public Currency() {
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}