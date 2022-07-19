package com.example.coffe.service;

import com.example.coffe.model.entity.Pembayaran;

import java.util.List;

public interface PembayaranService {

    List<Pembayaran> getPembayaran();

    Pembayaran getByid(Integer id);

    Pembayaran savePembayaran (Pembayaran pembayaran);

    void updatepembayaran (Integer id, Pembayaran pembayaran);

    void deletepembayaran (Integer id);
}
