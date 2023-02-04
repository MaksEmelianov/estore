package com.estore.service.impl;

import com.estore.entity.DeliveryAddress;
import com.estore.repository.DeliveryAddressRepository;
import com.estore.service.DeliveryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    private DeliveryAddressRepository deliveryAddressRepository;

    @Autowired
    public void setDeliveryAddressRepository(DeliveryAddressRepository deliveryAddressRepository) {
        this.deliveryAddressRepository = deliveryAddressRepository;
    }

    @Override
    public List<DeliveryAddress> getAddressesByUserId(Long userId) {
        return deliveryAddressRepository.findAllByUserId(userId);
    }

    @Override
    public DeliveryAddress getAddressById(Long id) {
        return deliveryAddressRepository.findById(id).orElse(null);
    }
}
