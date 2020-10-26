package com.example.cooperativism.exception;



public class VotingNotOpenException extends  ResponseException{

    public VotingNotOpenException(String message){
        super(message, 404);

    }
}
