package com.rapido.communication_service.dto;

public class CallSignalDTO {

    private Long rideId;

    private Long senderId;

    private Long receiverId;

    private String signalType;

    private String signalData;

    public CallSignalDTO() {
    }

    public CallSignalDTO(Long rideId,
                         Long senderId,
                         Long receiverId,
                         String signalType,
                         String signalData) {

        this.rideId = rideId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.signalType = signalType;
        this.signalData = signalData;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getSignalType() {
        return signalType;
    }

    public void setSignalType(String signalType) {
        this.signalType = signalType;
    }

    public String getSignalData() {
        return signalData;
    }

    public void setSignalData(String signalData) {
        this.signalData = signalData;
    }
}