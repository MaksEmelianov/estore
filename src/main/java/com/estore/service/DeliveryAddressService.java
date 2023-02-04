package com.estore.service;

import com.estore.entity.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {
    List<DeliveryAddress> getAddressesByUserId(Long userId);
    DeliveryAddress getAddressById(Long id);
}
