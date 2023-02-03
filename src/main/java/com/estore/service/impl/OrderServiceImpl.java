package com.estore.service.impl;

import com.estore.component.ShoppingCart;
import com.estore.entity.Order;
import com.estore.service.OrderService;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order makeOrder(ShoppingCart cart, Principal principal, String phoneNumber, Long deliveryAddressId) {
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        return null;
    }
}
