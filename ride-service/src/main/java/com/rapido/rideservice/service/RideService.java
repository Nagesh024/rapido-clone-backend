package com.rapido.rideservice.service;

import com.rapido.rideservice.dto.RideRequestDTO;
import com.rapido.rideservice.dto.RideResponseDTO;
import com.rapido.rideservice.entity.Ride;
import com.rapido.rideservice.entity.RideStatus;
import com.rapido.rideservice.exception.RideException;
import com.rapido.rideservice.repository.RideRepository;
import com.rapido.rideservice.util.DistanceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RideService {

    private final RideRepository rideRepository;
    private final DistanceUtil distanceUtil;

    public RideService(RideRepository rideRepository, DistanceUtil distanceUtil) {
        this.rideRepository = rideRepository;
        this.distanceUtil = distanceUtil;
    }

    @Transactional
    public RideResponseDTO requestRide(String userEmail, RideRequestDTO dto) {

        validateCoordinates(dto);

        Long userId = 1L;      // temporary until auth-service/user-service integration
        Long driverId = 101L;  // temporary matched driver

        double distance = distanceUtil.calculateDistance(
                dto.getPickupLatitude(),
                dto.getPickupLongitude(),
                dto.getDropLatitude(),
                dto.getDropLongitude()
        );

        double fare = 40 + (distance * 12);

        Ride ride = new Ride();
        ride.setUserId(userId);
        ride.setDriverId(driverId);
        ride.setPickupLatitude(dto.getPickupLatitude());
        ride.setPickupLongitude(dto.getPickupLongitude());
        ride.setDropLatitude(dto.getDropLatitude());
        ride.setDropLongitude(dto.getDropLongitude());
        ride.setEstimatedDistance(distance);
        ride.setEstimatedFare(fare);
        ride.setStatus(RideStatus.REQUESTED);
        ride.setRequestedAt(LocalDateTime.now());

        Ride savedRide = rideRepository.save(ride);

        return new RideResponseDTO(
                savedRide.getId(),
                savedRide.getUserId(),
                savedRide.getDriverId(),
                savedRide.getStatus(),
                savedRide.getEstimatedDistance(),
                savedRide.getEstimatedFare(),
                "Ride requested successfully"
        );
    }

    private void validateCoordinates(RideRequestDTO dto) {

        if (dto.getPickupLatitude() == null || dto.getPickupLongitude() == null ||
                dto.getDropLatitude() == null || dto.getDropLongitude() == null) {
            throw new RideException("Coordinates cannot be null");
        }

        if (dto.getPickupLatitude().equals(dto.getDropLatitude()) &&
                dto.getPickupLongitude().equals(dto.getDropLongitude())) {
            throw new RideException("Pickup and drop location cannot be same");
        }
    }
    @Transactional
    public RideResponseDTO acceptRide(Long rideId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RideException("Ride not found"));

        if (ride.getStatus() != RideStatus.REQUESTED) {
            throw new RideException("Only requested rides can be accepted");
        }

        ride.setStatus(RideStatus.ACCEPTED);
        Ride updatedRide = rideRepository.save(ride);

        return convertToResponse(updatedRide, "Ride accepted successfully");
    }

    @Transactional
    public RideResponseDTO startRide(Long rideId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RideException("Ride not found"));

        if (ride.getStatus() != RideStatus.ACCEPTED) {
            throw new RideException("Only accepted rides can be started");
        }

        ride.setStatus(RideStatus.STARTED);
        Ride updatedRide = rideRepository.save(ride);

        return convertToResponse(updatedRide, "Ride started successfully");
    }

    @Transactional
    public RideResponseDTO completeRide(Long rideId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RideException("Ride not found"));

        if (ride.getStatus() != RideStatus.STARTED) {
            throw new RideException("Only started rides can be completed");
        }

        ride.setStatus(RideStatus.COMPLETED);
        ride.setCompletedAt(LocalDateTime.now());
        Ride updatedRide = rideRepository.save(ride);

        return convertToResponse(updatedRide, "Ride completed successfully");
    }

    @Transactional
    public RideResponseDTO cancelRide(Long rideId) {
        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RideException("Ride not found"));

        if (ride.getStatus() == RideStatus.COMPLETED) {
            throw new RideException("Completed ride cannot be cancelled");
        }

        ride.setStatus(RideStatus.CANCELLED);
        Ride updatedRide = rideRepository.save(ride);

        return convertToResponse(updatedRide, "Ride cancelled successfully");
    }

    private RideResponseDTO convertToResponse(Ride ride, String message) {
        return new RideResponseDTO(
                ride.getId(),
                ride.getUserId(),
                ride.getDriverId(),
                ride.getStatus(),
                ride.getEstimatedDistance(),
                ride.getEstimatedFare(),
                message
        );
    }
}