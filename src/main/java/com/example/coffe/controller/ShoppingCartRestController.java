package com.example.coffe.controller;

import com.example.coffe.model.dto.OrderDTO;
import com.example.coffe.model.dto.ResponseOrderDTO;
import com.example.coffe.model.entity.*;
import com.example.coffe.service.ServiceCustomer;
import com.example.coffe.service.ServiceMenuImp;
import com.example.coffe.service.ServiceOrderImp;
import com.example.coffe.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins="http://localhost:5173")
@RestController
@RequestMapping("/orders")
public class ShoppingCartRestController {

    private ServiceOrderImp serviceOrderImp;

    private ServiceMenuImp serviceMenuImp;

    private ServiceCustomer serviceCustomer;

    public ShoppingCartRestController(ServiceOrderImp serviceOrderImp, ServiceMenuImp serviceMenuImp, ServiceCustomer serviceCustomer) {
        this.serviceOrderImp = serviceOrderImp;
        this.serviceMenuImp = serviceMenuImp;
        this.serviceCustomer = serviceCustomer;
    }

    private Logger logger = LoggerFactory.getLogger(ShoppingCartRestController.class);

    @GetMapping("/getAllMenu")
    public ResponseEntity<List<Menu>> getAllProducts() {

        List<Menu> productList = serviceMenuImp.getAllProducts();

        return ResponseEntity.ok(productList);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders() {

        List<Order> productList = serviceOrderImp.getAllOrders();

        return ResponseEntity.ok(productList);
    }

    @GetMapping("/getAllCart")
    public ResponseEntity<List<ShoppingCart>> getAllCart() {

        List<ShoppingCart> cart = serviceOrderImp.getAllCart();

        return ResponseEntity.ok(cart);
    }

    @GetMapping("/getAllOrders/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable Integer orderId) {

        Order order = serviceOrderImp.getOrderDetail(orderId);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/getAllOrders")
    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        logger.info("Request Payload " + orderDTO.toString());
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        float amount = serviceOrderImp.getCartAmount(orderDTO.getCartItems());

        Customer customer = new Customer(orderDTO.getCustomerName(), orderDTO.getCustomerAlamat(), orderDTO.getCustomerNotelp());
        Integer customerIdFromDb = serviceCustomer.isCustomerPresent(customer);
        if (customerIdFromDb != null) {
            customer.setId(customerIdFromDb);
            logger.info("Id Customer sudah ada : " + customerIdFromDb);
        }else{
            customer = serviceCustomer.saveCustomer(customer);
            logger.info("Simpan Customer beserta id : " + customer.getId());
        }
        Order order = new Order(orderDTO.getOrderDescription(), customer, orderDTO.getCartItems());
        order = serviceOrderImp.saveOrder(order);
        logger.info("Order proses sukses..");

        responseOrderDTO.setAmount(amount);
        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
        responseOrderDTO.setOrderId(order.getId());
        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

        logger.info("test push..");

        return ResponseEntity.ok(responseOrderDTO);
    }
}
