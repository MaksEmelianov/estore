package com.estore.controller;

import com.estore.component.ShoppingCart;
import com.estore.entity.Order;
import com.estore.entity.User;
import com.estore.service.DeliveryAddressService;
import com.estore.service.OrderService;
import com.estore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@Controller
@RequestMapping("/order")
public class OrderController {
    private UserService userService;
    private OrderService orderService;
    private DeliveryAddressService deliveryAddressService;

    private ShoppingCart shoppingCart;

    @GetMapping("/fill")
    public String orderFill(Principal principal, Model model) {
        if (Objects.isNull(principal)) {
            return "redirect:/login";
        }
        model.addAttribute("cart", shoppingCart);
        model.addAttribute("deliveryAddresses",
                deliveryAddressService.getAddressesByUserId(userService.getByUserName(principal).getId()));
        return "order-filler";
    }

    @PostMapping("confirm")
    public String orderConfirm(Principal principal, Model model,
                               @RequestParam(name = "phoneNumber") String phoneNumber,
                               @RequestParam(name = "deliveryAddress") Long deliveryAddressId) {
        if (Objects.isNull(principal)) {
            return "redirect:/login";
        }
        model.addAttribute("order",
                orderService.makeOrder(shoppingCart, principal, phoneNumber, deliveryAddressId));
        return "order-before-purchase";
    }

    @GetMapping("/result/{id}")
    public String orderConfirm(Principal principal, Model model,
                               @PathVariable(name = "id") Long orderId) {
        if (Objects.isNull(principal)) {
            return "redirect:/login";
        }
        User user = userService.getByUserName(principal);
        Order order = orderService.getOrderById(orderId);
        if (!user.getId().equals(order.getUser().getId())) {
            return "redirect:/";
        }
        model.addAttribute("order", order);
        return "order-result";
    }
}
