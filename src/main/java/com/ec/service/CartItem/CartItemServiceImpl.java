package com.ec.service.CartItem;

import com.ec.dao.CartDao;
import com.ec.dao.CartItemDao;
import com.ec.dao.ProductDao;
import com.ec.dto.CartItemRequestDTO;
import com.ec.entity.CartEntity;
import com.ec.entity.CartItemEntity;
import com.ec.entity.Product1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemDao cartItemDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    public CartItemEntity createCartItem(CartItemRequestDTO cartItemRequestDTO) {
        CartItemEntity cartItem = new CartItemEntity();

        int quantity = cartItemRequestDTO.getQuantity();
        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity. Quantity should be greater than zero.");
        }
        cartItem.setQuantity(quantity);

        Long cartId = cartItemRequestDTO.getCartId();
        if (cartId != null) {
            Optional<CartEntity> optionalCart = cartDao.findById(cartId);
            if (optionalCart.isPresent()) {
                cartItem.setCart(optionalCart.get());
            } else {
                throw new IllegalArgumentException("Invalid cartId");
            }
        }

        int productId = cartItemRequestDTO.getProductId();
        if (productId != -1) {
            Optional<Product1> optionalProduct = productDao.findById(productId);
            if (optionalProduct.isPresent()) {
                cartItem.setProduct(optionalProduct.get());
            } else {
                throw new IllegalArgumentException("Invalid productId");
            }
        }

        return cartItemDao.save(cartItem);
    }

    public CartItemEntity updateCartItem(Long cartItemId, CartItemRequestDTO cartItemRequestDTO) {
        CartItemEntity existingCartItem = cartItemDao.findById(cartItemId)
                .orElseThrow(() -> new NoSuchElementException("CartItem not found"));

        int quantity = cartItemRequestDTO.getQuantity();
        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity. Quantity should be greater than zero.");
        }
        existingCartItem.setQuantity(quantity);

        Long cartId = cartItemRequestDTO.getCartId();
        if (cartId != null) {
            Optional<CartEntity> optionalCart = cartDao.findById(cartId);
            if (optionalCart.isPresent()) {
                existingCartItem.setCart(optionalCart.get());
            } else {
                throw new IllegalArgumentException("Invalid cartId");
            }
        } else {
            existingCartItem.setCart(null);
        }

        int productId = cartItemRequestDTO.getProductId();
        if (productId != -1) {
            Optional<Product1> optionalProduct = productDao.findById(productId);
            if (optionalProduct.isPresent()) {
                existingCartItem.setProduct(optionalProduct.get());
            } else {
                throw new IllegalArgumentException("Invalid productId");
            }
        } else {
            existingCartItem.setProduct(null);
        }

        return cartItemDao.save(existingCartItem);
    }

    public void deleteCartItem(Long cartItemId) {
        cartItemDao.deleteById(cartItemId);
    }

    public List<CartItemEntity> getAllCartItems() {
        return cartItemDao.findAll();
    }

    public CartItemEntity getCartItemById(Long cartItemId) {
        return cartItemDao.findById(cartItemId)
                .orElseThrow(() -> new NoSuchElementException("CartItem not found"));
    }



}
