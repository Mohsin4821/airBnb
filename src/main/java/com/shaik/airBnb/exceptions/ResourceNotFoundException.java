package com.shaik.airBnb.exceptions;

public class ResourceNotFoundException extends CustomException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

