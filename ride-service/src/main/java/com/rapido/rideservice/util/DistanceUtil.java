package com.rapido.rideservice.util;

import org.springframework.stereotype.Component;

@Component
public class DistanceUtil {

    private static final double EARTH_RADIUS_KM = 6371.0;

    public double calculateDistance(
            double lat1,
            double lon1,
            double lat2,
            double lon2) {

        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);

        double diffLat = Math.toRadians(lat2 - lat1);
        double diffLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(diffLat / 2) * Math.sin(diffLat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(diffLon / 2) * Math.sin(diffLon / 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        return EARTH_RADIUS_KM * c;
    }
}