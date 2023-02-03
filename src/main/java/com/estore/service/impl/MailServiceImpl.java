package com.estore.service.impl;

import com.estore.entity.Order;
import com.estore.service.MailService;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Override
    public void sendMail(String email, String subject, String text) {

    }

    @Override
    public void sendOrderMail(Order order) {

    }
}
