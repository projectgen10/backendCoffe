package com.example.coffe.repository;

import com.example.coffe.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer getCustomerByAlamatAndNameAndNotelp(String alamat,String name, String notelp);
}
