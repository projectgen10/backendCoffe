package com.example.coffe.repository;

import com.example.coffe.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Optional <Menu> findById (Integer idMenu);
}
