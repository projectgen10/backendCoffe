package com.example.coffe.model.dto;

public class MenuDto {

    private Integer idMenu;
    private String namaMenu;
    private String namaJenis;
    private Integer stock;
    private Float harga;
    private String name;
    private String type;

    public MenuDto (String namaMenu, String namaJenis, Integer stock, Float harga, String name, String type) {
        this.namaMenu = namaMenu;
        this.namaJenis = namaJenis;
        this.stock = stock;
        this.harga = harga;
        this.name = name;
        this.type = type;
    }
    public MenuDto() {

    }

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

    public Float getHarga() {
        return harga;
    }

    public void setHarga(Float harga) {
        this.harga = harga;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
