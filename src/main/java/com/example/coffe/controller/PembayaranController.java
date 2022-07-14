package com.example.coffe.controller;

import com.example.coffe.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {
    @Autowired
    PembayaranRepository pembayaranRepository;
}
