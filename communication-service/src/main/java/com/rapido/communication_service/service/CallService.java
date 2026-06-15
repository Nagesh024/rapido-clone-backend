package com.rapido.communication_service.service;

import com.rapido.communication_service.dto.CallSignalDTO;
import com.rapido.communication_service.entity.CallSession;
import com.rapido.communication_service.repository.CallSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CallService {

    @Autowired
    private CallSessionRepository callSessionRepository;

    public CallSession initiateCall(CallSignalDTO dto) {

        CallSession session = new CallSession();

        session.setRideId(dto.getRideId());
        session.setCallerId(dto.getSenderId());
        session.setReceiverId(dto.getReceiverId());
        session.setStatus("INITIATED");
        session.setStartedAt(LocalDateTime.now());

        return callSessionRepository.save(session);
    }

    public CallSession acceptCall(CallSignalDTO dto) {

        CallSession session = getLatestCallByRideId(dto.getRideId());

        session.setStatus("ACCEPTED");

        return callSessionRepository.save(session);
    }

    public CallSession rejectCall(CallSignalDTO dto) {

        CallSession session = getLatestCallByRideId(dto.getRideId());

        session.setStatus("REJECTED");
        session.setEndedAt(LocalDateTime.now());

        return callSessionRepository.save(session);
    }

    public CallSession endCall(CallSignalDTO dto) {

        CallSession session = getLatestCallByRideId(dto.getRideId());

        session.setStatus("ENDED");
        session.setEndedAt(LocalDateTime.now());

        return callSessionRepository.save(session);
    }

    private CallSession getLatestCallByRideId(Long rideId) {

        return callSessionRepository
                .findTopByRideIdOrderByStartedAtDesc(rideId)
                .orElseThrow(() -> new RuntimeException("Call not found for rideId: " + rideId));
    }
    public void markMissedCall(Long rideId) {

        CallSession session = getLatestCallByRideId(rideId);

        if ("INITIATED".equals(session.getStatus())) {

            session.setStatus("MISSED");
            session.setEndedAt(LocalDateTime.now());

            callSessionRepository.save(session);

            System.out.println("Call marked as MISSED for rideId: " + rideId);
        }
    }
}