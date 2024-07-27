package com.ganeshgc.hotel_service.exception;

public class ResourceNotFoundException extends RuntimeException  {
    public ResourceNotFoundException(String message) {
        super("Hotel is not found with id :: " +message);
    }

}
