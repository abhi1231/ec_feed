package com.ec.service.CartItem;

import com.ec.entity.CartItemEntity;

import java.util.List;

public interface CartItemService {

    List<CartItemEntity> getAllCartItems();

    CartItemEntity getCartItemById(String cartItemId);

    CartItemEntity createCartItem(CartItemEntity cartItem);

    CartItemEntity updateCartItem(String cartItemId, CartItemEntity cartItem);

    void deleteCartItem(String cartItemId);
}
