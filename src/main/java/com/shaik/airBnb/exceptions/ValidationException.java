package com.shaik.airBnb.exceptions;

public class ValidationException extends CustomException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}

