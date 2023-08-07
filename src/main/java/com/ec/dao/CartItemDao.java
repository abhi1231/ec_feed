package com.ec.dao;

import com.ec.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartItemDao extends JpaRepository<CartItemEntity,Long>{

    @Query(value = "SELECT * FROM cartitem WHERE cart_id = ?1", nativeQuery = true)
    List<CartItemEntity> findByCartIdNative(Long cartId);
}
