package com.example.coffe.service;

import com.example.coffe.model.entity.Menu;
import com.example.coffe.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class ServiceMenuImp implements ServiceMenu {

    @Autowired
    MenuRepository menuRepository;

    @Override
    public Menu getMenuByidMenu(String idMenu) {
        return menuRepository.findById(idMenu).get();
    }

    @Override
    public void updateMenu(String idMenu, Menu menu) {
        Menu menu1 = menuRepository.findById(idMenu).get();
        System.out.println(menu1.toString());
        menu1.setNamaMenu(menu.getNamaMenu());
        menu1.setStock(menu.getStock());
        menu1.setHarga(menu.getHarga());
        menuRepository.save(menu1);
    }

    @Override
    public void deleteMenu(String idMenu) { menuRepository.deleteById(idMenu);
    }

    public Menu store(MultipartFile file, Menu menu) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Menu menu1 = new Menu(fileName, file.getContentType(), file.getBytes());
        menu1.setNamaMenu(menu.getNamaMenu());
        menu1.setHarga(menu.getHarga());
        menu1.setStock(menu.getStock());
        return menuRepository.save(menu1);
    }

    public Menu getFile(String idMenu) {
        return menuRepository.findById(idMenu).get();
    }

    public Stream<Menu> getAllFiles() {
        return menuRepository.findAll().stream();
    }

}
