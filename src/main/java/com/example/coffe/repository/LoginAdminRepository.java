package com.example.coffe.repository;

import com.example.coffe.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginAdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByNoTelpAndPass (String noTelp, String pass);
}
