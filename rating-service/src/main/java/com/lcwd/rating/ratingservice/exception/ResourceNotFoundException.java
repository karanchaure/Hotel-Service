package com.lcwd.rating.ratingservice.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Rating not found on the server !!!");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
