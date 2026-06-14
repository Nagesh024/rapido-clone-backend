package com.rapido.authserver.controller;

import com.rapido.authserver.model.Ride;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/abac")
public class ABACController {

    @GetMapping("/ride/{rideId}")
    public String accessRide(
            @PathVariable Long rideId,
            Authentication authentication) {

        Ride ride = new Ride(
                101L,
                "driver",
                "user"
        );

        String loggedUser = authentication.getName();

        if (loggedUser.equals(ride.getDriverUsername())
                || loggedUser.equals(ride.getRiderUsername())
                || loggedUser.equals("admin")) {

            return "Access Granted To Ride " + rideId;
        }

        return "Access Denied";
    }
}