package com.rapido.rideservice.controller;

import com.rapido.rideservice.dto.ApiResponse;
import com.rapido.rideservice.dto.RideRequestDTO;
import com.rapido.rideservice.dto.RideResponseDTO;
import com.rapido.rideservice.service.RideService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    // =========================
    // HEALTH CHECK (PUBLIC)
    // =========================
    @GetMapping("/health")
    public ApiResponse<String> health() {
        return new ApiResponse<>(true, "Ride Service is UP", "OK");
    }

    // =========================
    // REQUEST RIDE (SECURED + VALIDATED)
    // =========================
    @PostMapping("/request")
    public ApiResponse<RideResponseDTO> requestRide(
            @RequestParam String userEmail,
            @Valid @RequestBody RideRequestDTO dto) {

        return new ApiResponse<>(
                true,
                "Ride requested",
                rideService.requestRide(userEmail, dto)
        );
    }

    @PutMapping("/accept/{rideId}")
    public ApiResponse<RideResponseDTO> accept(@PathVariable Long rideId) {
        return new ApiResponse<>(true, "Accepted", rideService.acceptRide(rideId));
    }

    @PutMapping("/start/{rideId}")
    public ApiResponse<RideResponseDTO> start(@PathVariable Long rideId) {
        return new ApiResponse<>(true, "Started", rideService.startRide(rideId));
    }

    @PutMapping("/complete/{rideId}")
    public ApiResponse<RideResponseDTO> complete(@PathVariable Long rideId) {
        return new ApiResponse<>(true, "Completed", rideService.completeRide(rideId));
    }

    @PutMapping("/cancel/{rideId}")
    public ApiResponse<RideResponseDTO> cancel(@PathVariable Long rideId) {
        return new ApiResponse<>(true, "Cancelled", rideService.cancelRide(rideId));
    }
}