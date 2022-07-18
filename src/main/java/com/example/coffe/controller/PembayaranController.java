package com.example.coffe.controller;

import com.example.coffe.model.dto.*;
import com.example.coffe.model.entity.Pembayaran;
import com.example.coffe.model.entity.User;
import com.example.coffe.repository.PembayaranRepository;
import com.example.coffe.service.PembayaranService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {

    private final PembayaranRepository pembayaranRepository;
    private final PembayaranService pembayaranService;
//    private final PembayaranDto pembayaranDto;

    public PembayaranController(PembayaranRepository pembayaranRepository,PembayaranService pembayaranService) {
        this.pembayaranRepository = pembayaranRepository;
        this.pembayaranService = pembayaranService;
    }

    //masih error, kalo dijalankan ttp bisa, tpi pas dimasukkan eror
    @PostMapping(value = "/addpembayaran")
    public ResponseEntity<?> savePembayaran(@RequestBody Pembayaran pembayaran){
        Pembayaran createdUser = pembayaranService.savePembayaran(pembayaran);
        return new ResponseEntity<Object>(createdUser, HttpStatus.CREATED);
    }

//    @PostMapping("/pembayarann/tambah")
//    public PembayaranResponse<PembayaranDto> pembayaran(@RequestBody PembayaranDto pembayaranDto){
//        Pembayaran pembayaran = pembayaranNew(pembayaranDto);
//        PembayaranResponse<PembayaranDto> response = new PembayaranResponse<>();
//        Optional<Pembayaran> optional = pembayaranRepository.findByQty(pembayaranDto.getQty(), pembayaranDto.getPrice());
//        if(optional.isPresent()){
//            response.setMessages("Error, Data Sudah Tersedia.");
//        } else {
//            pembayaranRepository.save(pembayaran);
//            response.setMessages("Berhasil Tambah Data");
//            response.setData(pembayaranDto);
//        }
//        return response;
//    }

//    public Pembayaran pembayaranNew(PembayaranDto dto){
//        Pembayaran pemb = new Pembayaran();
//        pemb.setQty(dto.getQty());
//        pemb.setPrice(dto.getPrice());
//        return pemb;
//    }

    @GetMapping("/pembayarann/{id}")
    public PembayaranGabunganDto getListPembayar(@PathVariable Integer id){
        Optional<Pembayaran> pembayaran = pembayaranRepository.findById(id);
        PembayaranGabunganDto dto = new PembayaranGabunganDto();
        if (pembayaran.isPresent()){
            Pembayaran pembayaran1 = pembayaran.get();
            dto.setNama(pembayaran1.getUser().getNama());
            dto.setNamaJenis(pembayaran1.getJenis().getNamaJenis());
            dto.setNamaMenu(pembayaran1.getMenu().getNamaMenu());
            dto.setQty(pembayaran1.getQty().toString());
            dto.setPrice(pembayaran1.getPrice().toString());
        }
        return dto;
    }

    @GetMapping("/pembayarann")
    public List<PembayaranGabunganDto> getListPembayaran() {
        List<PembayaranGabunganDto> list = new ArrayList();
        for (Pembayaran p :pembayaranRepository.findAll()){
            list.add(convertEntityPembayaran(p));
        }
        return list;
    }

    public PembayaranGabunganDto convertEntityPembayaran(Pembayaran entity){
        PembayaranGabunganDto dto = new PembayaranGabunganDto();
        dto.setNama(entity.getUser().getNama());
        dto.setNamaMenu(entity.getMenu().getNamaMenu());
        dto.setNamaJenis(entity.getJenis().getNamaJenis());
        dto.setQty(entity.getQty().toString());
        dto.setPrice(entity.getPrice().toString());

        return dto;
    }

}
