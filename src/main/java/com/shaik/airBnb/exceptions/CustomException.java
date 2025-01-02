package com.shaik.airBnb.exceptions;

public class CustomException extends RuntimeException {
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
