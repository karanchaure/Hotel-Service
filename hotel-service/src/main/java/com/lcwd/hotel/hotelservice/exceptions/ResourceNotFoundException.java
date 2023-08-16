package com.lcwd.hotel.hotelservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("Requested Hotel not Found !!!");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
