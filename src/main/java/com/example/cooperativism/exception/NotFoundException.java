package com.example.cooperativism.exception;

public class NotFoundException extends  ResponseException{

    public NotFoundException(String message){
        super(message, 404);

    }
}
