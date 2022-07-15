package com.example.coffe.model.dto;

public class MenuDto {

    private Integer idMenu;
    private Integer idjenis;
    private String namaMenu;
    private Integer stock;
    private Double harga;

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdjenis() {
        return idjenis;
    }

    public void setIdjenis(Integer idjenis) {
        this.idjenis = idjenis;
    }
}
