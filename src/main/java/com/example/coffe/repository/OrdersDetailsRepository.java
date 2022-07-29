package com.example.coffe.repository;

import com.example.coffe.model.entity.Detail_Pembayaran;
import com.example.coffe.model.entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersDetailsRepository extends JpaRepository<OrdersDetails, String> {

    @Query(value = "select nama, namaMenu, namaJenis, qty, harga, harga*qty as total from orders_details + order by total desc ", nativeQuery = true)
    List<OrdersDetails> findByOrders(String id);

    Optional<OrdersDetails> findById(String id);
}
