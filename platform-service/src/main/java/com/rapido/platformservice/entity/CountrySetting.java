package com.rapido.platformservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "country_settings")
public class CountrySetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String currency;

    private String timezone;

    public CountrySetting() {
    }

    public CountrySetting(Long id, String country, String currency, String timezone) {
        this.id = id;
        this.country = country;
        this.currency = currency;
        this.timezone = timezone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}