package com.ec.service.Cart;

import com.ec.entity.CartEntity;

import java.util.List;
import java.util.Optional;

public interface CartService {



    List<CartEntity> getAllCarts();

    public Optional<CartEntity> getCartById(Long cartId);

    public CartEntity createCart(CartEntity cartEntity);

    public CartEntity updateCart(Long cartId, CartEntity cartEntity);

    public void deleteCart(Long cartId);
}
