package com.rapido.globalservice.business;

import jakarta.persistence.*;

@Entity
@Table(
        name = "country_business_rules",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_country_vehicle",
                        columnNames = {
                                "country_code",
                                "vehicle_type"
                        }
                )
        }
)
public class CountryBusinessRule {

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
            name = "vehicle_type",
            nullable = false,
            length = 50
    )
    private String vehicleType;

    @Column(nullable = false)
    private Boolean active;

    public CountryBusinessRule() {
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

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}