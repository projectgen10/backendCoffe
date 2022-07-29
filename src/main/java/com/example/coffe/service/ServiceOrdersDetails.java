package com.example.coffe.service;

import com.example.coffe.model.entity.OrdersDetails;
import com.example.coffe.model.entity.Pembayaran;

public interface ServiceOrdersDetails {

    OrdersDetails getOrdsById(String id);

    OrdersDetails insert(OrdersDetails ordersDetails);

    void updateOrders(String id, OrdersDetails ordersDetails);

    void deleteOrders(String id);
}
