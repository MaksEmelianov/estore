package com.estore.service;

import com.estore.entity.Order;

public interface MailMessageBuilder {
    String buildOrderEmail(Order order);
}
