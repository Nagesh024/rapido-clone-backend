package com.rapido.search.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Document(indexName = "drivers")
public class DriverDocument {

    @Id
    private String driverId;

    private String name;

    private double rating;
    private Integer completedRides;
    private Double acceptanceRate;

    public Integer getCompletedRides() {
		return completedRides;
	}

	public void setCompletedRides(Integer completedRides) {
		this.completedRides = completedRides;
	}

	public Double getAcceptanceRate() {
		return acceptanceRate;
	}

	public void setAcceptanceRate(Double acceptanceRate) {
		this.acceptanceRate = acceptanceRate;
	}
	private String vehicleType;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @GeoPointField
    private GeoPoint location;

    public DriverDocument() {}

    public DriverDocument(String driverId, String name, double rating,
                          String vehicleType, GeoPoint location) {
        this.driverId = driverId;
        this.name = name;
        this.rating = rating;
        this.vehicleType = vehicleType;
        this.location = location;
    }

    // getters & setters

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }
}