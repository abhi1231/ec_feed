package com.ec.controller;

import com.ec.entity.CartEntity;
import com.ec.service.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
     CartService cartService;

    // Endpoint to retrieve all carts
    @GetMapping
    public List<CartEntity> getAllCarts() {
        return cartService.getAllCarts();
    }

    // Endpoint to retrieve a cart by cart ID
    @GetMapping("/{cartId}")
    public Optional<CartEntity> getCartById(@PathVariable("cartId") Long cartId) {
        return cartService.getCartById(cartId);
    }

    // Endpoint to create a new cart
    @PostMapping
    public CartEntity createCart(@RequestBody CartEntity cartEntity) {
        return cartService.createCart(cartEntity);
    }

    // Endpoint to update an existing cart
    @PutMapping("/{cartId}")
    public CartEntity updateCart(@PathVariable("cartId")Long cartId, @RequestBody CartEntity cartEntity) {
        return cartService.updateCart(cartId, cartEntity);
    }

    // Endpoint to delete a cart by cart ID
    @DeleteMapping("/{cartId}")
    public void deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
    }
}
