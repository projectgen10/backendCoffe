package com.example.coffe.model.dto;

public class ResponseMessageDetail<T> {
    private String Messages;
    private String Data;

    public ResponseMessageDetail(String messages, String data) {
        Messages = messages;
        Data = data;

    }

    public String getMessages() {
        return Messages;
    }

    public void setMessages(String messages) {
        this.Messages = messages;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        this.Data = data;
    }
}
