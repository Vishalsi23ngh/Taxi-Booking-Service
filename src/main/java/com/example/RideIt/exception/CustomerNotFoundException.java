package com.example.RideIt.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String messege){
        super(messege);
    }
}
