package com.example.coffe.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_jenis")
public class Jenis {
    @Id
    @Column(name = "id_jenis")
    private String idJenis;
    @Column(name = "nama_jenis")
    private String namaJenis;
    @Column(name = "gambar")
    private String gambar;

    public String getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(String idJenis) {
        this.idJenis = idJenis;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
