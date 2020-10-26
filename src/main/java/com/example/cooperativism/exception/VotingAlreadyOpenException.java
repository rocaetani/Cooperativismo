package com.example.cooperativism.exception;

public class VotingAlreadyOpenException extends  ResponseException{

    public VotingAlreadyOpenException(String message){
        super(message, 406);

    }
}
