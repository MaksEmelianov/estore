package com.estore.service;

import com.estore.entity.Order;

public interface MailService {
    void sendMail(String email, String subject, String text);
    void sendOrderMail(Order order);
}
