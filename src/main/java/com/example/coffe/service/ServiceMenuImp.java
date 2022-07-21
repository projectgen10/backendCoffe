package com.example.coffe.service;

import com.example.coffe.model.entity.Menu;
import com.example.coffe.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMenuImp implements ServiceMenu {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public Menu getMenuByidMenu(Integer idMenu) {
        return menuRepository.findById(idMenu).get();
    }

    @Override
    public void updateMenu(Integer idMenu, Menu menu) {
        Menu menu1 = menuRepository.findById(idMenu).get();
        System.out.println(menu1.toString());
        menu1.setNamaMenu(menu.getNamaMenu());
        menu1.setStock(menu.getStock());
        menu1.setHarga(menu.getHarga());
        menuRepository.save(menu1);
    }

    @Override
    public void deleteMenu(Integer idMenu) {
        menuRepository.deleteById(idMenu);
    }
}
