package com.rapido.globalservice.location;

import jakarta.persistence.*;

@Entity
@Table(name = "service_zones")
public class ServiceZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zone_code", nullable = false, unique = true)
    private String zoneCode;

    @Column(name = "zone_name", nullable = false)
    private String zoneName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "supported_ride_types")
    private String supportedRideTypes;

    @Column(name = "operating_hours")
    private String operatingHours;

    @Column(name = "pricing_rule")
    private String pricingRule;

    @Column(nullable = false)
    private Boolean active;

    public ServiceZone() {
    }

    public Long getId() {
        return id;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getSupportedRideTypes() {
        return supportedRideTypes;
    }

    public void setSupportedRideTypes(String supportedRideTypes) {
        this.supportedRideTypes = supportedRideTypes;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    public String getPricingRule() {
        return pricingRule;
    }

    public void setPricingRule(String pricingRule) {
        this.pricingRule = pricingRule;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}