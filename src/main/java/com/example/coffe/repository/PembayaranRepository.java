package com.example.coffe.repository;

import com.example.coffe.model.entity.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, Integer> {

//    @Query (
//            value = "select new com.example.coffe.model.dto.PembayaranDto(p.id, p.qty, p.nama, p.price) from Pembayaran p inner join User u on u.idUser = p.idUser"
//    )
//    List<Pembayaran> getAllPembayaran();
}
