package com.example.buildFilterSpecification.exception;

public class FilterServiceException extends RuntimeException {

    public FilterServiceException(String message) {
        super(message);
    }

    public FilterServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

