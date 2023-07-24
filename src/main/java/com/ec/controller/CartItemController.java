package com.ec.controller;

import com.ec.entity.CartItemEntity;
import com.ec.service.CartItem.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

   // private final List<CartItemEntity> cartItems = new ArrayList<>();
    @Autowired
    private CartItemService cartItemService;
    @GetMapping
    public List<CartItemEntity> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("/{cartItemId}")
    public CartItemEntity getCartItemById(@PathVariable("cartItemId") String cartItemId) {
        return cartItemService.getCartItemById(cartItemId);
    }

    @PostMapping
    public ResponseEntity<CartItemEntity> createCartItem(@RequestBody CartItemEntity cartItem) {
        CartItemEntity cIE = cartItemService.createCartItem(cartItem);
        return ResponseEntity.ok(cIE);
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItemEntity> updateCartItem(@PathVariable("cartItemId") String cartItemId, @RequestBody CartItemEntity cartItem) {
        CartItemEntity cartItemUp = cartItemService.updateCartItem(cartItemId, cartItem);
       return ResponseEntity.ok().body(cartItemUp);
    }

    @DeleteMapping("/{cartItemId}")
    public void deleteCartItem(@PathVariable("cartItemId") String cartItemId) {
        cartItemService.deleteCartItem(cartItemId);
    }
}
