package com.example.cooperativism.exception;


public class AssociateAlreadyVoteException extends  ResponseException{

    public AssociateAlreadyVoteException(String message){
        super(message, 406);

    }
}