package com.rapido.rideservice.controller;

import com.rapido.rideservice.dto.RideRequestDTO;
import com.rapido.rideservice.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    
    @PostMapping("/request")
    public Map<String, Object> requestRide(@RequestBody RideRequestDTO requestDTO) {

        try {
            String rideId = rideService.requestRide(requestDTO);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Ride Requested Successfully");
            response.put("rideId", rideId);
            response.put("status", "PENDING");

            return response;

        } catch (Exception e) {
            e.printStackTrace(); // 🔥 IMPORTANT
            throw e;
        }
    }
}