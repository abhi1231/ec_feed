package com.ec.controller;


import com.ec.dto.CartRequestDTO;
import com.ec.entity.CartEntity;
import com.ec.service.cart.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    CartServiceImpl cartServiceImpl;

    @PostMapping
    public ResponseEntity<CartEntity> createCart(@RequestBody CartRequestDTO cartRequestDTO) {
        try {
            CartEntity savedCart = cartServiceImpl.createCart(cartRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCart);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{cartId}")
    public ResponseEntity<CartEntity> updateCart(
            @PathVariable Long cartId,
            @RequestBody CartRequestDTO cartRequestDTO
    ) {
        try {
            CartEntity updatedCart = cartServiceImpl.updateCart(cartId, cartRequestDTO);
            return ResponseEntity.ok(updatedCart);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
        try {
            cartServiceImpl.deleteCart(cartId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CartEntity>> getAllCarts() {
        List<CartEntity> carts = cartServiceImpl.getAllCarts();
        return ResponseEntity.ok(carts);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartEntity> getCartById(@PathVariable Long cartId) {
        try {
            CartEntity cart = cartServiceImpl.getCartById(cartId);
            return ResponseEntity.ok(cart);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
