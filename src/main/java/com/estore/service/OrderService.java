package com.estore.service;

import com.estore.component.ShoppingCart;
import com.estore.entity.Order;

import java.security.Principal;

public interface OrderService {
    Order makeOrder(ShoppingCart cart, Principal principal,
                    String phoneNumber, Long deliveryAddressId);
    Order getOrderById(Long id);
}
