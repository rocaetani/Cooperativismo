package com.example.cooperativism.exception;


public class VotingExpiredException extends  ResponseException{

    public VotingExpiredException(String message){
        super(message, 406);

    }
}
