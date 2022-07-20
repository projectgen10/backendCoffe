package com.example.coffe.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_pembayaran")
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pembayaran")
    public Integer id_pemb;

    @Column(name = "qty")
    public Integer qty;

    @Column(name = "price")
    public Double price;

    public Integer getId_pemb() {
        return id_pemb;
    }

    public void setId_pemb(Integer id_pemb) {
        this.id_pemb = id_pemb;
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
}
