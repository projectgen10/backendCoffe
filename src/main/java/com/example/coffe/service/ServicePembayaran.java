package com.example.coffe.service;

import com.example.coffe.model.entity.Pembayaran;

public interface ServicePembayaran {
    Pembayaran getPembById(Integer id_pemb);
    Pembayaran insert(Pembayaran pembayaran);
    void updatePembayaran(Integer id_pemb, Pembayaran pembayaran);

    void deletePembayaran(Integer id_pemb);
}
