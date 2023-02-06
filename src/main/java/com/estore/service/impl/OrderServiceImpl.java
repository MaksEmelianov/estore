package com.estore.service.impl;

import com.estore.component.ShoppingCart;
import com.estore.entity.Order;
import com.estore.entity.OrderStatus;
import com.estore.entity.User;
import com.estore.repository.OrderRepository;
import com.estore.repository.UserRepository;
import com.estore.service.DeliveryAddressService;
import com.estore.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    private DeliveryAddressService deliveryAddressService;

    @Override
    public Order makeOrder(ShoppingCart cart, Principal principal,
                           String phoneNumber, Long deliveryAddressId) {
        User user = userRepository.findByUsername(principal.getName());
        Order order = new Order();
        order.setId(0L);
        order.setUser(user);
        order.setPrice(cart.getTotalCost());
        order.setDeliveryPrice(Math.random() * 1000);
        order.setDeliveryAddress(deliveryAddressService.getAddressById(deliveryAddressId));
        order.setPhoneNumber(phoneNumber);
        order.setDeliveryDate(LocalDateTime.now().plusDays((int) (Math.random() * 10)));
        order.setOrderStatus(OrderStatus.CREATED);
        order.setOrderItemList(new ArrayList<>(cart.getItems()));
        return order;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
