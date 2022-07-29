package com.example.coffe.controller;

import com.example.coffe.model.dto.*;
import com.example.coffe.model.entity.Detail_Pembayaran;
import com.example.coffe.model.entity.Pembayaran;
import com.example.coffe.repository.DetailPembayaranRepository;
import com.example.coffe.repository.PembayaranRepository;
import com.example.coffe.service.ServicePembayaran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {


    @Autowired
    private DetailPembayaranRepository detailPembayaranRepository;
    @Autowired
    private PembayaranRepository pembayaranRepository;
    @Autowired
    ServicePembayaran servicePembayaran;

//    public PembayaranController(DetailPembayaranRepository detailPembayaranRepository, PembayaranRepository pembayaranRepository) {
//        this.detailPembayaranRepository = detailPembayaranRepository;
//        this.pembayaranRepository = pembayaranRepository;
//
//    }

    //tambah data lewat service dan auto id
    @PostMapping("/tambah")
    public ResponseEntity<Pembayaran> savePembayaran(@RequestBody Pembayaran pembayaran) {
        Pembayaran pembayaran1 = servicePembayaran.insert(pembayaran);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("pembayaran", "/tambah/" + pembayaran1.getId_pemb().toString());
        return new ResponseEntity<>(pembayaran1, httpHeaders, HttpStatus.CREATED);
    }

    //update Data pembayaran
    @PutMapping({"/{id_pembayaran}"})
    public ResponseEntity<Pembayaran> updatePembayaran(@PathVariable("id_pembayaran") Integer id_pemb,
                                                       @RequestBody Pembayaran pembayaran) {
        servicePembayaran.updatePembayaran(id_pemb, pembayaran);
        return new ResponseEntity<>(servicePembayaran.getPembById(id_pemb), HttpStatus.OK);
    }

    @DeleteMapping("/{id_pembayaran}")
    public ResponseEntity<Pembayaran> deletePembayaran(@PathVariable("id_pembayaran") Integer id_pemb) {
        servicePembayaran.deletePembayaran(id_pemb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pembayarann/{id}")
    public PembayaranGabunganDto getListPembayar(@PathVariable Integer id) {
        Optional<Detail_Pembayaran> detail_pembayaran = detailPembayaranRepository.findById(id);
        PembayaranGabunganDto dto = new PembayaranGabunganDto();
        if (detail_pembayaran.isPresent()) {
            Detail_Pembayaran detailPembayaran1 = detail_pembayaran.get();
            dto.setNama(detailPembayaran1.getUser().getNama());
            dto.setNamaJenis(detailPembayaran1.getJenis().getNamaJenis());
            dto.setNamaMenu(detailPembayaran1.getMenu().getNamaMenu());
            dto.setQty(detailPembayaran1.getPembayaran().getQty());
            dto.setPrice(detailPembayaran1.getPembayaran().getPrice());
        }
        return dto;
    }

    @GetMapping("/pembayaran")
    public List<PembayaranDto> getListPembayaran() {
        List<PembayaranDto> list = new ArrayList();
        for (Pembayaran pembayaran : pembayaranRepository.findAll()) {
            list.add(convertEntityPembayaran(pembayaran));
        }
        return list;
    }

    @GetMapping("/detailpembayarann")
    public List<PembayaranGabunganDto> getListDetailPembayaran() {
        List<PembayaranGabunganDto> list = new ArrayList();
        for (Detail_Pembayaran p : detailPembayaranRepository.findAll()) {
            list.add(convertEntityDetailPembayaran(p));
        }
        return list;
    }

    public PembayaranDto convertEntityPembayaran(Pembayaran entity) {
        PembayaranDto dtoo = new PembayaranDto();
        dtoo.setQty(entity.getQty());
        dtoo.setPrice(entity.getPrice());

        return dtoo;
    }

    public PembayaranGabunganDto convertEntityDetailPembayaran(Detail_Pembayaran entity) {
        PembayaranGabunganDto dto = new PembayaranGabunganDto();
        dto.setNama(entity.getUser().getNama());
        dto.setNamaMenu(entity.getMenu().getNamaMenu());
        dto.setNamaJenis(entity.getJenis().getNamaJenis());
        dto.setQty(entity.getPembayaran().getQty());
        dto.setPrice(entity.getPembayaran().getPrice());

        return dto;
    }

}
