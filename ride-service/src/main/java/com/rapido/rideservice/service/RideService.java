package com.rapido.rideservice.service;

import com.rapido.rideservice.dto.RideRequestDTO;
import com.rapido.rideservice.dto.RideResponseDTO;
import com.rapido.rideservice.entity.Ride;
import com.rapido.rideservice.entity.RideStatus;
import com.rapido.rideservice.exception.RideException;
import com.rapido.rideservice.repository.RideRepository;
import com.rapido.rideservice.util.DistanceUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RideService {

    private static final Logger logger =
            LoggerFactory.getLogger(RideService.class);

    private final RideRepository rideRepository;
    private final DistanceUtil distanceUtil;

    public RideService(RideRepository rideRepository, DistanceUtil distanceUtil) {
        this.rideRepository = rideRepository;
        this.distanceUtil = distanceUtil;
    }

    // =========================
    // REQUEST RIDE
    // =========================
    @Transactional
    public RideResponseDTO requestRide(String userEmail, RideRequestDTO dto) {

        logger.info("AUDIT_LOG | REQUEST_RIDE | userEmail={} | riderId={}",
                userEmail, dto.getRiderId());

        validateCoordinates(dto);

        Long userId = 1L;
        Long driverId = 101L;

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

        logger.info("RIDE_CREATED | rideId={} | status=REQUESTED", savedRide.getId());

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

    // =========================
    // ACCEPT RIDE
    // =========================
    @Transactional
    public RideResponseDTO acceptRide(Long rideId) {

        logger.info("AUDIT_LOG | ACCEPT_RIDE | rideId={}", rideId);

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> {
                    logger.warn("RIDE_NOT_FOUND | rideId={}", rideId);
                    return new RideException("Ride not found");
                });

        if (ride.getStatus() != RideStatus.REQUESTED) {
            logger.warn("INVALID_STATE | ACCEPT_RIDE | rideId={} | status={}",
                    rideId, ride.getStatus());
            throw new RideException("Only requested rides can be accepted");
        }

        ride.setStatus(RideStatus.ACCEPTED);
        Ride updatedRide = rideRepository.save(ride);

        return convertToResponse(updatedRide, "Ride accepted successfully");
    }

    // =========================
    // START RIDE
    // =========================
    @Transactional
    public RideResponseDTO startRide(Long rideId) {

        logger.info("AUDIT_LOG | START_RIDE | rideId={}", rideId);

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RideException("Ride not found"));

        if (ride.getStatus() != RideStatus.ACCEPTED) {
            logger.warn("INVALID_STATE | START_RIDE | rideId={} | status={}",
                    rideId, ride.getStatus());
            throw new RideException("Only accepted rides can be started");
        }

        ride.setStatus(RideStatus.STARTED);
        Ride updatedRide = rideRepository.save(ride);

        return convertToResponse(updatedRide, "Ride started successfully");
    }

    // =========================
    // COMPLETE RIDE
    // =========================
    @Transactional
    public RideResponseDTO completeRide(Long rideId) {

        logger.info("AUDIT_LOG | COMPLETE_RIDE | rideId={}", rideId);

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RideException("Ride not found"));

        if (ride.getStatus() != RideStatus.STARTED) {
            logger.warn("INVALID_STATE | COMPLETE_RIDE | rideId={} | status={}",
                    rideId, ride.getStatus());
            throw new RideException("Only started rides can be completed");
        }

        ride.setStatus(RideStatus.COMPLETED);
        ride.setCompletedAt(LocalDateTime.now());
        Ride updatedRide = rideRepository.save(ride);

        return convertToResponse(updatedRide, "Ride completed successfully");
    }

    // =========================
    // CANCEL RIDE
    // =========================
    @Transactional
    public RideResponseDTO cancelRide(Long rideId) {

        logger.info("AUDIT_LOG | CANCEL_RIDE | rideId={}", rideId);

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RideException("Ride not found"));

        if (ride.getStatus() == RideStatus.COMPLETED) {
            logger.warn("INVALID_CANCEL_ATTEMPT | rideId={}", rideId);
            throw new RideException("Completed ride cannot be cancelled");
        }

        ride.setStatus(RideStatus.CANCELLED);
        Ride updatedRide = rideRepository.save(ride);

        return convertToResponse(updatedRide, "Ride cancelled successfully");
    }

    // =========================
    // VALIDATION
    // =========================
    private void validateCoordinates(RideRequestDTO dto) {

        if (dto.getPickupLatitude() == null || dto.getPickupLongitude() == null ||
                dto.getDropLatitude() == null || dto.getDropLongitude() == null) {

            logger.warn("VALIDATION_FAILED | NULL_COORDINATES");
            throw new RideException("Coordinates cannot be null");
        }

        if (dto.getPickupLatitude().equals(dto.getDropLatitude()) &&
                dto.getPickupLongitude().equals(dto.getDropLongitude())) {

            logger.warn("VALIDATION_FAILED | SAME_PICKUP_DROP");
            throw new RideException("Pickup and drop location cannot be same");
        }
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