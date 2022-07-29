package com.example.coffe.repository;

import com.example.coffe.model.entity.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, Integer> {

    Optional<Pembayaran> findById(Integer id_pemb);
}
