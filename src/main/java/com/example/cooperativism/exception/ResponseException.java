package com.example.cooperativism.exception;


public class ResponseException extends  RuntimeException{
    private int responseStatus;

    public ResponseException(String message, int responseStatus){
        super(message);
        this.responseStatus = responseStatus;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }
}
