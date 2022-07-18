package com.example.coffe.controller;

import com.example.coffe.model.dto.DefaultResponse;
import com.example.coffe.model.dto.MenuDto;
import com.example.coffe.model.entity.Menu;
import com.example.coffe.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @PostMapping("/pilihan")
    public DefaultResponse pilihan(@RequestBody MenuDto menuDto){

        Optional<Menu> optionalMenu = menuRepository.findByIdIdMenu(menuDto.getIdMenu());
        DefaultResponse df = new DefaultResponse();
        if (optionalMenu.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Menu yang anda pilih telah tersimpan ");
        } else{
            df.setStatus(Boolean.FALSE);
            df.setMessage("Menu yang anda pilih tidak tersedia");
        }
        return df;
    }
    @GetMapping("/byid/{idmenu}")
    public DefaultResponse getByidMenu(@PathVariable Integer idMenu){

        DefaultResponse df = new DefaultResponse();
        Optional<Menu> menuOps =  menuRepository.findById(idMenu);
        if (menuOps.isPresent()){
            df.setStatus(Boolean.TRUE);
            df.setMessage("Menu yang anda pilih telah tersimpan );
        } else{
            df.setStatus(Boolean.FALSE);
            df.setMessage("Menu yang anda pilih tidak tersedia");
        }

        return df;
    }
}
