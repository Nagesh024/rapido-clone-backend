package com.rapido.globalservice.notification;

public class NotificationResponse {

    private String language;

    private String message;

    public NotificationResponse() {
    }

    public NotificationResponse(
            String language,
            String message
    ) {
        this.language = language;
        this.message = message;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(
            String language
    ) {
        this.language = language;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(
            String message
    ) {
        this.message = message;
    }
}