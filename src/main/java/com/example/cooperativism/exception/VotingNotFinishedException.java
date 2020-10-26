package com.example.cooperativism.exception;



public class VotingNotFinishedException extends  ResponseException{

    public VotingNotFinishedException(String message){
        super(message, 406);

    }
}