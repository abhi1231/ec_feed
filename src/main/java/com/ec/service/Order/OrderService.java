package com.ec.service.Order;

import com.ec.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderEntity> getAllOrders();

    Optional<OrderEntity> getOrderById(int order_item_id);

    OrderEntity createOrder(OrderEntity order);

    OrderEntity updateOrder(int order_item_id, OrderEntity order);

    void deleteOrder(int order_item_id);
}
