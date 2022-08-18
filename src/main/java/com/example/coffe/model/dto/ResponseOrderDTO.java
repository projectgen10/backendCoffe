package com.example.coffe.model.dto;

public class ResponseOrderDTO {
    private Float amount;
    private Integer invoiceNumber;
    private String date;
    private String OrderDescription;
    private Integer orderId;

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderDescription() {
        return OrderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        OrderDescription = orderDescription;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
