package com.ec.controller;

import com.ec.dto.CartItemGetResponse;
import com.ec.dto.CartItemRequestDTO;
import com.ec.entity.CartItemEntity;
import com.ec.entity.Product1;
import com.ec.service.CartItem.CartItemService;
import com.ec.service.CartItem.CartItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/cartitems")
public class CartItemController {


    @Autowired
    private CartItemServiceImpl cartItemServiceImpl;

    @PostMapping
    public ResponseEntity<CartItemEntity> createCartItem(@RequestBody CartItemRequestDTO cartItemRequestDTO) {
        try {
            CartItemEntity savedCartItem = cartItemServiceImpl.createCartItem(cartItemRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCartItem);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItemEntity> updateCartItem(
            @PathVariable Long cartItemId,
            @RequestBody CartItemRequestDTO cartItemRequestDTO
    ) {
        try {
            CartItemEntity updatedCartItem = cartItemServiceImpl.updateCartItem(cartItemId, cartItemRequestDTO);
            return ResponseEntity.ok(updatedCartItem);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long cartItemId) {
        try {
            cartItemServiceImpl.deleteCartItem(cartItemId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CartItemEntity>> getAllCartItems() {
        List<CartItemEntity> cartItems = cartItemServiceImpl.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @GetMapping("/{cartItemId}")
    public ResponseEntity<CartItemEntity> getCartItemById(@PathVariable Long cartItemId) {
        try {
            CartItemEntity cartItem = cartItemServiceImpl.getCartItemById(cartItemId);
            return ResponseEntity.ok(cartItem);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //get record by cart id
    @GetMapping("/{cartId}/bycartid")
    public ResponseEntity<List<CartItemEntity>> getCartItemsByCartId(@PathVariable Long cartId) {
        List<CartItemEntity> cartItems = cartItemServiceImpl.getCartItemsByCartId(cartId);
        if (cartItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @GetMapping("/GetItemByCartId/{cartId}")
    public ResponseEntity<List<CartItemGetResponse>> getCartItemsByCartIdNew(@PathVariable Long cartId) {
        List<CartItemEntity> cartItems = cartItemServiceImpl.getCartItemsByCartId(cartId);
        if (cartItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<CartItemGetResponse> cartItemResponses = new ArrayList<>();
        for (CartItemEntity cartItem : cartItems) {
            CartItemGetResponse itemResponse = new CartItemGetResponse();
            itemResponse.setCartItemId(cartItem.getCartItemId());
            itemResponse.setQuantity(cartItem.getQuantity());

            Product1 product = cartItem.getProduct();
            itemResponse.setProductName(product.getName());
            itemResponse.setProductDescription(product.getDescription());
            itemResponse.setPrice(product.getPrice());
            itemResponse.setImage(product.getImage());

            cartItemResponses.add(itemResponse);
        }

        return new ResponseEntity<>(cartItemResponses, HttpStatus.OK);
    }

}
