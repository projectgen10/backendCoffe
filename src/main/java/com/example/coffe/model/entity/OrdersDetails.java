package com.example.coffe.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "OrdersDetails")
public class OrdersDetails {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_orders")
    private String id;

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

    private Integer qty;

    public OrdersDetails(){

    }

    public OrdersDetails(Integer idUser, User user, Integer idMenu, Menu menu, Integer idJenis, Jenis jenis, Integer qty) {
        this.idUser = idUser;
        this.user = user;
        this.idMenu = idMenu;
        this.menu = menu;
        this.idJenis = idJenis;
        this.jenis = jenis;
        this.qty = qty;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(Integer idJenis) {
        this.idJenis = idJenis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Jenis getJenis() {
        return jenis;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
