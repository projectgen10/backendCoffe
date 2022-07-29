package com.example.coffe.service;

import com.example.coffe.model.entity.Pembayaran;
import com.example.coffe.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePembayaranImpl implements ServicePembayaran{
    @Autowired
    PembayaranRepository pembayaranRepository;

    @Override
    public Pembayaran getPembById(Integer id_pemb) {

        return pembayaranRepository.findById(id_pemb).get();
    }

    @Override
    public Pembayaran insert(Pembayaran pembayaran) {
        return pembayaranRepository.save(pembayaran);
    }

    @Override
    public void updatePembayaran(Integer id_pemb, Pembayaran pembayaran) {
        Pembayaran pembayaran1 = pembayaranRepository.findById(id_pemb).get();
        System.out.println(pembayaran1.toString());
        pembayaran1.setQty(pembayaran.getQty());
        pembayaran1.setPrice(pembayaran.getPrice());
        pembayaranRepository.save(pembayaran1);
    }

    @Override
    public void deletePembayaran(Integer id_pemb) {
        pembayaranRepository.deleteById(id_pemb);
    }
}
