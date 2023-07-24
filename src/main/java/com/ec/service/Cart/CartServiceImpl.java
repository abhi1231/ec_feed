package com.ec.service.Cart;

import com.ec.dao.CartDao;

import com.ec.entity.CartEntity;
import com.ec.entity.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;



    @Override
    public List<CartEntity> getAllCarts() {
        return cartDao.findAll();
    }

    @Override
    public Optional<CartEntity> getCartById(Long cartId) {
        return cartDao.findById(cartId);
    }

    @Override
    public CartEntity createCart(CartEntity cartEntity) {
      return   cartDao.save(cartEntity);
    }

    @Override
    public CartEntity updateCart(Long cartId, CartEntity cartEntity) {
        return cartDao.save(cartEntity);
    }

    @Override
    public void deleteCart(Long cartId) {
        cartDao.deleteById(cartId);

    }
}
