package com.ganeshgc.userservice.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super("Resource not found: " + message);
    }

}
