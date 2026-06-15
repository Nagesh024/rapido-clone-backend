package com.rapido.communication_service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rideId;

    private Long senderId;

    private Long receiverId;

    @Column(length = 1000)
    private String message;

    private Boolean delivered;

    private Boolean read;

    private LocalDateTime sentAt;

    public ChatMessage() {
    }

    public ChatMessage(Long id,
                       Long rideId,
                       Long senderId,
                       Long receiverId,
                       String message,
                       Boolean delivered,
                       Boolean read,
                       LocalDateTime sentAt) {

        this.id = id;
        this.rideId = rideId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.delivered = delivered;
        this.read = read;
        this.sentAt = sentAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getDelivered() {
        return delivered;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }
}