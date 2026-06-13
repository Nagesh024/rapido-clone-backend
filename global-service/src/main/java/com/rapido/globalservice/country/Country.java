package com.rapido.globalservice.country;

import com.rapido.globalservice.common.BaseEntity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "countries",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_country_code",
                        columnNames = "country_code"
                )
        }
)
public class Country extends BaseEntity {

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
            name = "country_name",
            nullable = false,
            length = 100
    )
    private String countryName;

    @Column(
            name = "default_currency",
            nullable = false,
            length = 10
    )
    private String defaultCurrency;

    @Column(
            name = "default_language",
            nullable = false,
            length = 20
    )
    private String defaultLanguage;

    @Column(
            name = "time_zone",
            nullable = false,
            length = 100
    )
    private String timeZone;

    @Column(
            nullable = false
    )
    private Boolean active;

    public Country() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}