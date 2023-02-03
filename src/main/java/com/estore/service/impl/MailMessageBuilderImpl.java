package com.estore.service.impl;

import com.estore.entity.Order;
import com.estore.service.MailMessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MailMessageBuilderImpl implements MailMessageBuilder {
    @Override
    public String buildOrderEmail(Order order) {
        return null;
    }
}
