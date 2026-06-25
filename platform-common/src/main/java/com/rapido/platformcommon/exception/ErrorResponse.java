package com.rapido.platformcommon.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private boolean success;

    private String errorCode;

    private String message;

    private LocalDateTime timestamp;

    public ErrorResponse() {
    }

    public ErrorResponse(boolean success,
                         String errorCode,
                         String message,
                         LocalDateTime timestamp) {

        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}