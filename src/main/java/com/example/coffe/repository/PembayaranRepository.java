package com.example.coffe.repository;

import com.example.coffe.model.entity.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PembayaranRepository extends JpaRepository<Pembayaran, Integer> {
}
