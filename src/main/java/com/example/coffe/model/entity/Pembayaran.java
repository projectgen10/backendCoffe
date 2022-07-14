package com.example.coffe.model.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "tb_pembayaran")
public class Pembayaran {
    @Id

    @Column(name = "id_pembayaran")
    private Integer id;
    @Column(name = "qty")
    private int qty;
    @Column(name = "price")
    private Double price;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_user", insertable = false, updatable = false)
//    @Fetch(FetchMode.JOIN)
//    private Login login;
//
//    public Login getLogin() {
//        return login;
//    }
//
//    public void setLogin(Login login) {
//        this.login = login;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
