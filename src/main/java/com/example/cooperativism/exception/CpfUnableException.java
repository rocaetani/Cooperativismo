package com.example.cooperativism.exception;



public class CpfUnableException extends  ResponseException{

    public CpfUnableException(String message){
        super(message, 401);

    }
}