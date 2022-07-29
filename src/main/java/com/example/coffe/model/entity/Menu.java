package com.example.coffe.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_menu")
public class Menu {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_menu")
    private String idMenu;
    @Column(name = "nama_menu")
    private String namaMenu;
    @Column(name = "id_jenis")
    private String idJenis;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "harga")
    private Double harga;
    @Column(name = "nama_file")
    private String namaFile;
    @Column(name = "type")
    private String type;

    @Lob
    private byte[] data;

    public Menu() {
    }

    public Menu(String fileName, String contentType, byte[] bytes, Menu menu) {
    }

    public Menu(String namaFile, String type, byte[] data) {
        this.namaFile = namaFile;
        this.type = type;
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(String idJenis) {
        this.idJenis = idJenis;
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

    @OneToOne
    @JoinColumn(name = "idJenis", insertable = false, updatable = false)
    private Jenis jenis;

    public Jenis getJenis() {
        return jenis;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }
}
