package com.ec.dao;

import com.ec.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemDao extends JpaRepository<CartItemEntity,String>{
}
