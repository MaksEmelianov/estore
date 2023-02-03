package com.estore.service;

import com.estore.entity.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    List<DeliveryAddress> getUserAddresses(Long userId);
    DeliveryAddress getUserAddressById(Long id);
}
