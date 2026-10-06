package com.example.nasa_api.exception;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String message){
        super(message);
    }
}
