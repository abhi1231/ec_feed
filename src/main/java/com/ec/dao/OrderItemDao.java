package com.ec.dao;

import com.ec.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemDao extends JpaRepository<OrderItemEntity, Long> {
}
