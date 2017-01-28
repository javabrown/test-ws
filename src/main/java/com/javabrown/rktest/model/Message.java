package com.javabrown.rktest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message implements ResponseI {
    private String _message;

    public Message(String message){
        _message = message;
    }

    public void setMessage(String message){
        _message = message;
    }

    @JsonProperty("response")
    public String getMessage() {
        return _message;
    }
}