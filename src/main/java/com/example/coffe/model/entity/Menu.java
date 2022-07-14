package com.example.coffe.model.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "tb_menu")
public class Menu {
    @Id
    @Column(name = "id_menu")
    private Integer idMenu;
    @Column(name = "nama_menu")
    private String namaMenu;
    @Column(name = "id_jenis")
    private Integer idJenis;
    @Column(name = "stock")
    private int stock;
    @Column(name = "harga")
    private double harga;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn ("id_jenis", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Jenis jenis;

    public Jenis getJenis(){
        return jenis;
    }
    
    public void setJenis(Jenis jenis){
        this.jenis = jenis;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public Integer getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(Integer idJenis) {
        this.idJenis = idJenis;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}
