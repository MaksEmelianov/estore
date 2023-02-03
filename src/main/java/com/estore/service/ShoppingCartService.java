package com.estore.service;

import com.estore.component.ShoppingCart;
import com.estore.entity.Product;

import javax.servlet.http.HttpSession;

public interface ShoppingCartService {
    ShoppingCart getCurrentCart(HttpSession session);
    void resetCart(HttpSession session);
    void addToCart(HttpSession session, Long productId);
    void addToCart(HttpSession session, Product product);
    void removeFromCart(HttpSession session, Long productId);
    void removeFromCart(HttpSession session, Product product);
    void setProductCount(HttpSession session, Long productId, Long quantity);
    void setProductCount(HttpSession session, Product product, Long quantity);
    double getTotalCost(HttpSession session);
}
