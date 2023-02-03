package com.estore.service.impl;

import com.estore.component.ShoppingCart;
import com.estore.entity.Product;
import com.estore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Override
    public ShoppingCart getCurrentCart(HttpSession session) {
        return null;
    }

    @Override
    public void resetCart(HttpSession session) {

    }

    @Override
    public void addToCart(HttpSession session, Long productId) {

    }

    @Override
    public void addToCart(HttpSession session, Product product) {

    }

    @Override
    public void removeFromCart(HttpSession session, Long productId) {

    }

    @Override
    public void removeFromCart(HttpSession session, Product product) {

    }

    @Override
    public void setProductCount(HttpSession session, Long productId, Long quantity) {

    }

    @Override
    public void setProductCount(HttpSession session, Product product, Long quantity) {

    }

    @Override
    public double getTotalCost(HttpSession session) {
        return 0;
    }
}
