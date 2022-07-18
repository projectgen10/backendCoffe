package com.example.coffe.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_pembayaran")
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_pembayaran")
    private Integer id;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "price")
    private Double price;

    @Column(name = "id_user")
    private Integer idUser;

//  join user
    @OneToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

//    join menu
    @Column(name = "id_menu")
    private Integer idMenu;

    @OneToOne
    @JoinColumn(name = "id_menu", insertable = false, updatable = false)
    private Menu menu;

//  join jenis
    @Column(name = "id_jenis")
    private Integer idJenis;

    @OneToOne
    @JoinColumn(name = "id_jenis", insertable = false, updatable = false)
    private Jenis jenis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
