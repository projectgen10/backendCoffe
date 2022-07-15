package com.example.coffe.model.dto;

public class PembayaranDto {
    private Integer id;
    private Integer qty;
    private String nama;
    private Double price;

    public PembayaranDto(Integer id, Integer qty, String nama, Double price) {
        this.id = id;
        this.qty = qty;
        this.nama = nama;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
