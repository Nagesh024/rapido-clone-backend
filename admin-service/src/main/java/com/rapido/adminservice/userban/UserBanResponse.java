package com.rapido.adminservice.userban;

public class UserBanResponse {

    private Long userId;
    private String banType;
    private String reason;
    private String message;

    public UserBanResponse(Long userId, String banType, String reason, String message) {
        this.userId = userId;
        this.banType = banType;
        this.reason = reason;
        this.message = message;
    }

    public Long getUserId() { return userId; }
    public String getBanType() { return banType; }
    public String getReason() { return reason; }
    public String getMessage() { return message; }
}