package com.example.coffe.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    @Column(name = "no_telp")
    private String noTelp;
    private String pass;
    private String alamat;
    private String nama;

    private Integer idRole;

    private String namaFile;
    private String type;

    @Lob
    private byte[] data;

    @OneToOne
    @JoinColumn(name = "idRole", insertable = false, updatable = false)
    private Roles roles;


//    public enum role{
//        admin,user
//    }
    public User(){

    }

    public User(String namaFile, String type, byte[] data) {
        this.namaFile = namaFile;
        this.type = type;
        this.data = data;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
