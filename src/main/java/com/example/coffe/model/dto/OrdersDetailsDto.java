package com.example.coffe.model.dto;

public class OrdersDetailsDto {

    private String nama;
    private String namaMenu;
    private String namaJenis;
    private Integer qty;
    private Double harga;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getHarga()
    {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }
}
