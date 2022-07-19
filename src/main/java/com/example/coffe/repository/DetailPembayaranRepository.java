package com.example.coffe.repository;

import com.example.coffe.model.entity.Detail_Pembayaran;
import com.example.coffe.model.entity.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetailPembayaranRepository extends JpaRepository<Detail_Pembayaran, Integer> {
    Optional<Detail_Pembayaran> findById(Integer integer);
}
