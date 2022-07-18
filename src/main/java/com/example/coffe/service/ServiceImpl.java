package com.example.coffe.service;

import com.example.coffe.model.entity.Pembayaran;
import com.example.coffe.repository.PembayaranRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImpl implements PembayaranService {

    PembayaranRepository pembayaranRepository;

    public ServiceImpl(PembayaranRepository pembayaranRepository) {
        this.pembayaranRepository = pembayaranRepository;
    }


    @Override
    public List<Pembayaran> getPembayaran() {
        List<Pembayaran> pembayarans = new ArrayList<>();
        pembayaranRepository.findAll().forEach(pembayarans::add);

        return pembayarans;
    }

    @Override
    public Pembayaran getByid(Integer id) {
        return pembayaranRepository.findById(id).get();
    }

    @Override
    public Pembayaran savePembayaran(Pembayaran pembayaran) {
        return pembayaranRepository.save(pembayaran);
    }

    @Override
    public void updatepembayaran(Integer id, Pembayaran pembayaran) {
        Pembayaran pb = pembayaranRepository.findById(id).get();
        System.out.println(pb.toString());
        pb.setQty(pb.getQty());
        pb.setPrice(pb.getPrice());
        pembayaranRepository.save(pb);
    }

    @Override
    public void deletepembayaran(Integer id) {
        pembayaranRepository.deleteById(id);
    }
}
