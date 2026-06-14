package com.rapido.communication_service.dto;

public class TypingDTO {

    private Long rideId;

    private Long userId;

    private Boolean typing;

    public TypingDTO() {
    }

    public TypingDTO(Long rideId, Long userId, Boolean typing) {
        this.rideId = rideId;
        this.userId = userId;
        this.typing = typing;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getTyping() {
        return typing;
    }

    public void setTyping(Boolean typing) {
        this.typing = typing;
    }
}