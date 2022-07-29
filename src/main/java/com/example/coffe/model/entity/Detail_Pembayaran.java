package com.example.coffe.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_detail_pembayaran")
public class Detail_Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_detail_pembayaran")
    private Integer id;
    @Column(name = "id_pembayaran")
    private Integer id_pemb;
    @OneToOne
    @JoinColumn(name = "id_pemb", insertable = false, updatable = false)
    private Pembayaran pembayaran;
    @Column(name = "id_user")
    private Integer idUser;
    @OneToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    @Column(name = "id_menu")
    private Integer idMenu;

    @OneToOne
    @JoinColumn(name = "id_menu", insertable = false, updatable = false)
    private Menu menu;

    @Column(name = "id_jenis")
    private Integer idJenis;

    @OneToOne
    @JoinColumn(name = "id_jenis", insertable = false, updatable = false)
    private Jenis jenis;

    public Integer getId_pemb() {
        return id_pemb;
    }

    public void setId_pemb(Integer id_pemb) {
        this.id_pemb = id_pemb;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(Integer idJenis) {
        this.idJenis = idJenis;
    }

    public Jenis getJenis() {
        return jenis;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }
}
