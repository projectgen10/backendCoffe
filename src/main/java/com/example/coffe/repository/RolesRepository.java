package com.example.coffe.repository;

import com.example.coffe.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

    Optional<Roles> findByRole(String role);
}
