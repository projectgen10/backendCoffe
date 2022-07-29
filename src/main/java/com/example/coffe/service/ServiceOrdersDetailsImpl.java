package com.example.coffe.service;

import com.example.coffe.model.entity.OrdersDetails;
import com.example.coffe.repository.OrdersDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class ServiceOrdersDetailsImpl implements ServiceOrdersDetails {

    @Autowired
    private OrdersDetailsRepository ordersDetailsRepository;

    @Override
    public OrdersDetails getOrdsById(String id) {
        return ordersDetailsRepository.findById(id).get();
    }

    @Override
    public OrdersDetails insert(OrdersDetails ordersDetails) {

        return ordersDetailsRepository.save(ordersDetails);
    }

    @Override
    public void updateOrders(String id, OrdersDetails ordersDetails) {
        OrdersDetails ordersDetails1 = ordersDetailsRepository.findById(id).get();
        System.out.println(ordersDetails1.toString());
        ordersDetails1.setQty(ordersDetails.getQty());
        ordersDetailsRepository.save(ordersDetails1);
    }



    @Override
    public void deleteOrders(String id) {
        ordersDetailsRepository.deleteById(id);
    }
}
