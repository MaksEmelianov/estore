package com.estore.service.impl;

import com.estore.entity.DeliveryAddress;
import com.estore.service.DeliveryAddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    @Override
    public List<DeliveryAddress> getUserAddresses(Long userId) {
        return null;
    }

    @Override
    public DeliveryAddress getUserAddressById(Long id) {
        return null;
    }
}
