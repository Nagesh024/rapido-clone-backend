package com.rapido.communication_service.service;

import org.springframework.stereotype.Service;

@Service
public class RideAuthorizationService {

    public boolean isAuthorized(Long rideId, Long userId) {

        return rideId == 1L && (userId == 101L || userId == 202L);
    }
}