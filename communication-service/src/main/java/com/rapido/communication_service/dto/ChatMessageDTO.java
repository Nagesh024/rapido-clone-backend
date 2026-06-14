package com.rapido.communication_service.dto;

public class ChatMessageDTO {

    private Long rideId;

    private Long senderId;

    private Long receiverId;

    private String message;

    private MessageType type;

    public ChatMessageDTO() {
    }

    public ChatMessageDTO(Long rideId,
                          Long senderId,
                          Long receiverId,
                          String message,
                          MessageType type) {

        this.rideId = rideId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.type = type;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}