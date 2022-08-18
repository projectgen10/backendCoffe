package com.example.coffe.service;

import com.example.coffe.model.entity.Menu;
import com.example.coffe.model.entity.Order;
import com.example.coffe.model.entity.ShoppingCart;
import com.example.coffe.repository.MenuRepository;
import com.example.coffe.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceOrderImp {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MenuRepository menuRepository;

    public Order getOrderDetail(int orderId){
        Optional<Order> order = orderRepository.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }

    public float getCartAmount(List<ShoppingCart> shoppingCartList) {
        float totalCartAmount = 0;
        float singleCartAmount = 0;
        Integer availableQuantity = 0;

        for (ShoppingCart cart : shoppingCartList){
            Integer productId = cart.getProductId();
            Optional<Menu> menu = menuRepository.findById(productId);
            if (menu.isPresent()){
                Menu menu1 = menu.get();
                if (menu1.getStock() < cart.getQuantity()){
                    singleCartAmount = menu1.getHarga() * menu1.getStock();
                    cart.setQuantity(menu1.getStock());
                }else {
                    singleCartAmount = cart.getQuantity() * menu1.getHarga();
                    availableQuantity = menu1.getStock() - cart.getQuantity();
                }
                totalCartAmount = totalCartAmount + singleCartAmount;
                menu1.setStock(availableQuantity);
                availableQuantity = 0;
                cart.setProductName(menu1.getNamaMenu());
                cart.setAmount(singleCartAmount);
                menuRepository.save(menu1);
            }
        }
        return totalCartAmount;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
