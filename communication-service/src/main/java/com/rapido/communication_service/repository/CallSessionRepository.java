package com.rapido.communication_service.repository;

import com.rapido.communication_service.entity.CallSession;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallSessionRepository
        extends JpaRepository<CallSession, Long> {
	Optional<CallSession> findTopByRideIdOrderByStartedAtDesc(Long rideId);
}