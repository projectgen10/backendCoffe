package com.example.coffe.model.dto;

public class RegisResponse<T>{
    private String messages;
    private T data;

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
