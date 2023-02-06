package com.estore.service.impl;

import com.estore.component.ShoppingCart;
import com.estore.entity.Product;
import com.estore.service.ProductsService;
import com.estore.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private ProductsService productsService;

    @Override
    public ShoppingCart getCurrentCart(HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @Override
    public void resetCart(HttpSession session) {
        session.removeAttribute("cart");
    }

    @Override
    public void addToCart(HttpSession session, Long productId) {
        Product product = productsService.getById(productId);
        addToCart(session, product);
    }

    @Override
    public void addToCart(HttpSession session, Product product) {
        getCurrentCart(session).add(product);
    }

    @Override
    public void removeFromCart(HttpSession session, Long productId) {
        Product product = productsService.getById(productId);
        removeFromCart(session, product);
    }

    @Override
    public void removeFromCart(HttpSession session, Product product) {
        getCurrentCart(session).remove(product);
    }

    @Override
    public void setProductCount(HttpSession session, Long productId, Long quantity) {
        ShoppingCart cart = getCurrentCart(session);
        Product product = productsService.getById(productId);
        cart.setQuantity(product, quantity);
    }

    @Override
    public void setProductCount(HttpSession session, Product product, Long quantity) {
        getCurrentCart(session).setQuantity(product, quantity);
    }

    @Override
    public double getTotalCost(HttpSession session) {
        return getCurrentCart(session).getTotalCost();
    }
}
