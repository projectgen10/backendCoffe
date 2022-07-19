package com.example.coffe.controller;

import com.example.coffe.model.dto.DefaultResponse;
import com.example.coffe.model.dto.MenuDto;
import com.example.coffe.model.entity.Menu;
import com.example.coffe.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @PostMapping("/pilihan")
    public DefaultResponse pilihan(@RequestBody MenuDto menuDto) {

        Optional<Menu> optionalMenu = menuRepository.findById(menuDto.getIdMenu());
        DefaultResponse df = new DefaultResponse();
        if (optionalMenu.isPresent()) {
            df.setStatus(Boolean.TRUE);
            df.setMessage("MENU YANG ANDA PILIH TELAH TERSIMPAN");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("MENU YANG ANDA PILIH TIDAK TERSEDIA");
        }
        return df;
    }

    @GetMapping("/byid/{idmenu}")
    public DefaultResponse getByidMenu(@PathVariable Integer idMenu) {

        DefaultResponse df = new DefaultResponse();
        Optional<Menu> menuOps = menuRepository.findById(idMenu);
        if (menuOps.isPresent()) {
            df.setStatus(Boolean.TRUE);
            df.setMessage("MENU YANG ANDA PILIH TELAH TERSIMPAN");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("MENU YANG ANDA PILIH TIDAK TERSEDIA");
        }

        return df;
    }

    @PostMapping("/save")
    public DefaultResponse<MenuDto> saveMenu(@RequestBody MenuDto menuDto) {
        Menu menu = convertDtoToEntity(menuDto);
        DefaultResponse<MenuDto> response = new DefaultResponse<>();
        Optional<Menu> optional = menuRepository.findById (menuDto.getIdMenu());
        if (optional.isPresent()) {
            response.setMessage("ERROR, DATA MENU TELAH TERSEDIA");
        } else {
            menuRepository.save(menu);
            response.setMessage("DATA MENU BERHASIL TERSIMPAN");
            response.setData(menuDto);
        }
        return response;
    }

    @GetMapping("/listmenu")
    public List<MenuDto> getListMenu() {
        List<MenuDto> list = new ArrayList<>();
        for (Menu m : menuRepository.findAll()) {
            list.add(convertEntityToDto(m));
        }
        return list;
    }

    public List<MenuDto> listData() {
        List<MenuDto> list = new ArrayList<>();
        MenuDto m = new MenuDto();
        m.setIdMenu(001);
        m.setIdjenis(001);
        m.setNamaMenu("Kopi Busuk");
        m.setStock(50);
        m.setHarga(10000.0);

        list.add(m);

        MenuDto menuDto = new MenuDto();
        menuDto.setIdMenu(002);
        menuDto.setIdjenis(001);
        menuDto.setNamaMenu("Kopi Susu");
        menuDto.setStock(50);
        menuDto.setHarga(8000.0);
        list.add(menuDto);
        return list;
    }

    public Menu convertDtoToEntity(MenuDto dto) {
        Menu entity = new Menu();
        entity.setIdMenu(dto.getIdMenu());
        entity.setNamaMenu(dto.getNamaMenu());
        entity.setStock(dto.getStock());
        entity.setHarga(dto.getHarga());
        return entity;
    }

    public MenuDto convertEntityToDto(Menu entity) {
        MenuDto dto = new MenuDto();
        dto.setIdMenu(dto.getIdMenu());
        dto.setNamaMenu(dto.getNamaMenu());
        dto.setStock(dto.getStock());
        dto.setHarga(dto.getHarga());
        return dto;
    }
}