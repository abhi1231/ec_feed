package com.ec.service.cart;

import com.ec.dao.CartDao;

import com.ec.dao.CustomerDao;
import com.ec.dto.CartRequestDTO;
import com.ec.entity.CartEntity;
import com.ec.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private CustomerDao customerDao;

    public CartEntity createCart(CartRequestDTO cartRequestDTO) {
        CartEntity cart = new CartEntity();

        Long customerId = cartRequestDTO.getCustomerId();
        if (customerId != null) {
            Optional<Customer> optionalCustomer = customerDao.findById(customerId);
            if (optionalCustomer.isPresent()) {
                cart.setCustomer(optionalCustomer.get());
            } else {
                throw new IllegalArgumentException("Invalid customerId");
            }
        }

        return cartDao.save(cart);
    }

    public CartEntity updateCart(Long cartId, CartRequestDTO cartRequestDTO) {
        CartEntity existingCart = cartDao.findById(cartId)
                .orElseThrow(() -> new NoSuchElementException("Cart not found"));

        Long customerId = cartRequestDTO.getCustomerId();
        if (customerId != null) {
            Optional<Customer> optionalCustomer = customerDao.findById(customerId);
            if (optionalCustomer.isPresent()) {
                existingCart.setCustomer(optionalCustomer.get());
            } else {
                throw new IllegalArgumentException("Invalid customerId");
            }
        } else {
            existingCart.setCustomer(null);
        }

        return cartDao.save(existingCart);
    }

    public void deleteCart(Long cartId) {
        cartDao.deleteById(cartId);
    }

    public List<CartEntity> getAllCarts() {
        return cartDao.findAll();
    }

    public CartEntity getCartById(Long cartId) {
        return cartDao.findById(cartId)
                .orElseThrow(() -> new NoSuchElementException("Cart not found"));
    }




}
