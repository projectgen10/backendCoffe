package com.example.coffe.model.dto;

public class ResponseMessage {
    private String message;
    private String Data;
    public ResponseMessage(String message, String data){
        this.message = message;
        this.Data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
