package com.example.coffe.repository;

import com.example.coffe.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginUserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByNoTelpAndPass (String noTelp, String pass);
}
