package com.example.coffe.model.dto;

import com.example.coffe.model.entity.ShoppingCart;

import java.util.List;

public class OrderDTO {

    private String orderDescription;
    private List<ShoppingCart> cartItems;
    private String customerAlamat;
    private String customerName;
    private String customerNotelp;

    public OrderDTO() {
    }

    public OrderDTO(String orderDescription, List<ShoppingCart> cartItems, String customerAlamat, String customerName, String customerNotelp) {
        this.orderDescription = orderDescription;
        this.cartItems = cartItems;
        this.customerAlamat = customerAlamat;
        this.customerName = customerName;
        this.customerNotelp = customerNotelp;
    }

    public String getCustomerNotelp() {
        return customerNotelp;
    }

    public void setCustomerNotelp(String customerNotelp) {
        this.customerNotelp = customerNotelp;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public List<ShoppingCart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCart> cartItems) {
        this.cartItems = cartItems;
    }

    public String getCustomerAlamat() {
        return customerAlamat;
    }

    public void setCustomerAlamat(String customerAlamat) {
        this.customerAlamat = customerAlamat;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDescription='" + orderDescription + '\'' +
                ", cartItems=" + cartItems +
                ", customerAlamat='" + customerAlamat + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerNotelp='" + customerNotelp + '\'' +
                '}';
    }
}
