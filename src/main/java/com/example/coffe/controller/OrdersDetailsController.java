package com.example.coffe.controller;

import com.example.coffe.model.dto.PembayaranGabunganDto;
import com.example.coffe.model.dto.ResponseMessageDetail;
import com.example.coffe.model.dto.OrdersDetailsDto;
import com.example.coffe.model.entity.Detail_Pembayaran;
import com.example.coffe.model.entity.OrdersDetails;
import com.example.coffe.model.entity.Pembayaran;
import com.example.coffe.repository.OrdersDetailsRepository;
import com.example.coffe.service.ServiceOrdersDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersDetailsController {

    @Autowired
    private ServiceOrdersDetailsImpl serviceOrdersDetails;

    @Autowired
    private OrdersDetailsRepository ordersDetailsRepository;

    @GetMapping("/Orders")
    public List<OrdersDetailsDto> getListDetailPembayaran() {
        List<OrdersDetailsDto> list = new ArrayList();
        for (OrdersDetails p : ordersDetailsRepository.findAll()) {
            list.add(convertEntityDetailPembayaran(p));
        }
        return list;
    }

    @PostMapping("/Orders")
    public ResponseEntity<ResponseMessageDetail> savePembayaran(@RequestBody OrdersDetails ordersDetails) {
        String message = "";
        String data = "";
        try {
            serviceOrdersDetails.insert(ordersDetails);
            data = "Berhasil";
            message = "Menambahkan Orders: " + ordersDetails.getId();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageDetail(message, data));
        } catch (Exception e) {
            data = "Gagal";
            message = "Menambahkan Orders" + ordersDetails.getId() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageDetail(message, data));
        }
//        OrdersDetails ordersDetails1 = serviceOrdersDetails.insert(ordersDetails);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("orders", "" + ordersDetails1.getId().toString());
//        return new ResponseEntity<>(ordersDetails1, httpHeaders, HttpStatus.CREATED);
    }


    @PutMapping("/Orders/{id_orders}")
    public ResponseEntity<OrdersDetails> updateOrders(@PathVariable("id_orders") String id,
                                                          @RequestBody OrdersDetails ordersDetails) {
        serviceOrdersDetails.updateOrders(id, ordersDetails);
        return new ResponseEntity<>(serviceOrdersDetails.getOrdsById(id), HttpStatus.OK);
    }

    @DeleteMapping("/Orders/{id_orders}")
    public ResponseEntity<Pembayaran> deleteOrders(@PathVariable("id_orders") String id) {
        serviceOrdersDetails.deleteOrders(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public OrdersDetailsDto convertEntityDetailPembayaran(OrdersDetails entity) {
        OrdersDetailsDto dto = new OrdersDetailsDto();

        dto.setNama(entity.getUser().getNama());
        dto.setNamaMenu(entity.getMenu().getNamaMenu());
        dto.setNamaJenis(entity.getJenis().getNamaJenis());
        dto.setQty(entity.getQty());
        dto.setHarga(entity.getMenu().getHarga());

        return dto;
    }
}
