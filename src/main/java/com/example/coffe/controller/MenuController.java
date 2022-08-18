package com.example.coffe.controller;

import com.example.coffe.model.dto.*;
import com.example.coffe.model.entity.Jenis;
import com.example.coffe.model.entity.Menu;
import com.example.coffe.repository.JenisRepository;
import com.example.coffe.repository.MenuRepository;
import com.example.coffe.service.ServiceMenu;
import com.example.coffe.service.ServiceMenuImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private JenisRepository jenisRepository;
    @Autowired
    ServiceMenu serviceMenu;
    @Autowired
    ServiceMenuImp serviceMenuImp;

    @PostMapping("/pilihan")
    public DefaultResponse pilihan(@RequestBody MenuDto menuDto) {

        DefaultResponse df = new DefaultResponse();
        Optional<Menu> optionalMenu = menuRepository.findById(menuDto.getIdMenu());
        if (optionalMenu.isPresent()) {
            df.setStatus(Boolean.TRUE);
            df.setMessage("MENU YANG ANDA PILIH TELAH TERSIMPAN");
        } else {
            df.setStatus(Boolean.FALSE);
            df.setMessage("MENU YANG ANDA PILIH TIDAK TERSEDIA");
        }
        return df;
    }

    @GetMapping({"/byid/{idMenu}"})
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

    @PostMapping("/savejenis")
    public DefaultResponse<JenisDto> saveJenis(@RequestBody JenisDto jenisDto) {
        Jenis jenis = convertDtoToEntity(jenisDto);
        DefaultResponse<JenisDto> response = new DefaultResponse<>();
        Optional<Jenis> optional = jenisRepository.findById(jenisDto.getIdJenis());
        if (optional.isPresent()) {
            response.setMessage("ERROR, DATA MENU TELAH TERSEDIA");
        } else {
            jenisRepository.save(jenis);
            response.setMessage("DATA MENU BERHASIL TERSIMPAN");
            response.setData(jenisDto);
        }
        return response;
    }

    @GetMapping("/listmenuu")
    public List<MenuDto> getListMenu() {
        List<MenuDto> list = new ArrayList();
        for (Menu m : menuRepository.findAll()) {
            list.add(convertEntityToDto(m));
        }
        return list;
    }
    @GetMapping("/listmenu")
    public ResponseEntity<List<Menu>> getAllProducts() {

        List<Menu> productList = serviceMenuImp.getAllProducts();

        return ResponseEntity.ok(productList);
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, Menu menu) {
        String message = "";
        String data = "";
        try {
            serviceMenuImp.store(file, menu);
            data = "BERHASIL";
            message = "FILE BERHASI DIUPLOAD" + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, data));
        } catch (Exception e) {
            data = "GAGAL";
            message = "FILE TIDAK BERHASIL DIUPLOAD" + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, data));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFile() {
        List<ResponseFile> files = serviceMenuImp.getAllFiles().map(dbMenu -> {
            String fileDownloadUrl = ServletUriComponentsBuilder
                    .fromCurrentContextPath().path("/files/").path(dbMenu.getIdMenu().toString()).toUriString();
            return new ResponseFile(dbMenu.getNamaFile(), fileDownloadUrl, dbMenu.getType(), dbMenu.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping({"/files/{idMenu}"})
    public ResponseEntity<byte[]> getFile(@PathVariable Integer idMenu) {
        Menu menu = serviceMenuImp.getFile(idMenu);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                + menu.getNamaMenu() + "\"").body(menu.getData());
    }

    @PutMapping({"/upload/{idMenu}"})
    public ResponseEntity<Menu> updateMenu(@PathVariable("idMenu") Integer idMenu, @RequestBody Menu menu) {
        serviceMenu.updateMenu(idMenu, menu);
        return new ResponseEntity<>(serviceMenu.getMenuByidMenu(idMenu), HttpStatus.OK);
    }

    @DeleteMapping({"/{idMenu}"})
    public ResponseEntity<Menu> deleteMenu(@PathVariable("idMenu") Integer idMenu) {
        serviceMenu.deleteMenu(idMenu);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public Jenis convertDtoToEntity(JenisDto dto) {
        Jenis entity = new Jenis();
        entity.setIdJenis(dto.getIdJenis());
        entity.setNamaJenis(dto.getNamaJenis());
        return entity;
    }

    public Menu convertDtoToEntity(MenuDto dto) {
        Menu entity = new Menu();
        entity.setIdMenu(dto.getIdMenu());
        entity.setNamaMenu(dto.getNamaMenu());
        entity.setStock(dto.getStock());
        entity.setHarga(dto.getHarga().floatValue());
        return entity;
    }

    public MenuDto convertEntityToDto(Menu entity) {
        MenuDto dto = new MenuDto();
        dto.setIdMenu(entity.getIdMenu());
        dto.setType(entity.getType());
        dto.setName(entity.getNamaFile());
        dto.setNamaMenu(entity.getNamaMenu());
        dto.setStock(entity.getStock());
        dto.setHarga(entity.getHarga());
        return dto;
    }
}