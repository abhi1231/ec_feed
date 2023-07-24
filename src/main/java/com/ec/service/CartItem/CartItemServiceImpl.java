package com.ec.service.CartItem;

import com.ec.dao.CartItemDao;
import com.ec.entity.CartItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemDao cartItemDao;



    @Override
    public List<CartItemEntity> getAllCartItems() {
        return cartItemDao.findAll();
    }

    @Override
    public CartItemEntity getCartItemById(String cartItemId) {
        return cartItemDao.getReferenceById(cartItemId);
    }

    @Override
    public CartItemEntity createCartItem(CartItemEntity cartItem) {
        return cartItemDao.save(cartItem);
    }



    @Override
    public CartItemEntity updateCartItem(String cartItemId, CartItemEntity updatedCartItem) {
        CartItemEntity existingCartItem = cartItemDao.findById(cartItemId).orElse(null);

        if (existingCartItem != null) {

            existingCartItem.setCart_id(updatedCartItem.getCart_id());
            existingCartItem.setProduct_id(updatedCartItem.getProduct_id());
            existingCartItem.setQuantity(updatedCartItem.getQuantity());
            existingCartItem.setPrice(updatedCartItem.getPrice());

            return cartItemDao.save(existingCartItem);
        } else {
            return cartItemDao.save(updatedCartItem);
        }
    }

    @Override
    public void deleteCartItem(String cartItemId) {
         cartItemDao.deleteById(cartItemId);
    }
}
