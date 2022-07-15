package com.example.coffe.controller;

import com.example.coffe.model.entity.Pembayaran;
import com.example.coffe.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PembayaranController {
    @Autowired
    private PembayaranRepository pembayaranRepository;


//    @GetMapping("/pembayaran")
//    public ResponseEntity<List<Pembayaran>> getAllPembayaran(){
//        return ResponseEntity.ok(pembayaranRepository.getAllPembayaran());
//    }
}
