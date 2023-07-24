package com.ec.dao;
import com.ec.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<CartEntity,Long> {
}
