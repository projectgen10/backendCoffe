package com.example.coffe.service;

import com.example.coffe.model.entity.Menu;
import com.example.coffe.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

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
        System.out.println(menu1);
        menu1.setNamaMenu(menu.getNamaMenu());
//        menu1.setIdJenis(menu.getIdJenis());
        menu1.setStock(menu.getStock());
        menu1.setHarga(menu.getHarga());
        menuRepository.save(menu1);
    }

    @Override
    public void deleteMenu(Integer idMenu) { menuRepository.deleteById(idMenu);
    }

    public Menu store(MultipartFile file, Menu menu) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Menu menu1 = new Menu(fileName, file.getContentType(), file.getBytes());
        menu1.setNamaMenu(menu.getNamaMenu());
//        menu1.setIdJenis(menu.getIdJenis());
        menu1.setHarga(menu.getHarga());
        menu1.setStock(menu.getStock());
        return menuRepository.save(menu1);
    }

    public Menu getFile(Integer idMenu) {
        return menuRepository.findById(idMenu).get();
    }

    public Stream<Menu> getAllFiles() {
        return menuRepository.findAll().stream();
    }

    public List<Menu> getAllProducts() {
        return this.menuRepository.findAll();
    }

}
