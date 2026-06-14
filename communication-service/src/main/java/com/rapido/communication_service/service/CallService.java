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

    public CallSession endCall(Long callId) {

        CallSession session =
                callSessionRepository.findById(callId)
                        .orElseThrow(() ->
                                new RuntimeException("Call not found"));

        session.setStatus("ENDED");
        session.setEndedAt(LocalDateTime.now());

        return callSessionRepository.save(session);
    }
}