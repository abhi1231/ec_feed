package com.ec.service.orderItem;

import com.ec.dao.OrderDao;
import com.ec.dao.OrderItemDao;
import com.ec.dao.ProductDao;
import com.ec.dto.OrderItemRequestDTO;
import com.ec.entity.OrderEntity;
import com.ec.entity.OrderItemEntity;
import com.ec.entity.Product1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderItemServiceImpl {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private ProductDao productDao;

    public OrderItemEntity createOrderItem(OrderItemRequestDTO orderItemRequestDTO) {
        OrderItemEntity orderItem = new OrderItemEntity();
        orderItem.setQuantity(orderItemRequestDTO.getQuantity());
        orderItem.setPrice(orderItemRequestDTO.getPrice());

        Long orderId = orderItemRequestDTO.getOrderId();
        if (orderId != null) {
            Optional<OrderEntity> optionalOrder = orderDao.findById(orderId);
            if (optionalOrder.isPresent()) {
                orderItem.setOrder(optionalOrder.get());
            } else {
                throw new IllegalArgumentException("Invalid orderId");
            }
        }

        int productId = orderItemRequestDTO.getProductId();
        if (productId ==-1) {
            Optional<Product1> optionalProduct = productDao.findById(productId);
            if (optionalProduct.isPresent()) {
                orderItem.setProduct(optionalProduct.get());
            } else {
                throw new IllegalArgumentException("Invalid productId");
            }
        }

        return orderItemDao.save(orderItem);
    }

    public OrderItemEntity updateOrderItem(Long orderItemId, OrderItemRequestDTO orderItemRequestDTO) {
        OrderItemEntity existingOrderItem = orderItemDao.findById(orderItemId)
                .orElseThrow(() -> new NoSuchElementException("OrderItem not found"));

        existingOrderItem.setQuantity(orderItemRequestDTO.getQuantity());
        existingOrderItem.setPrice(orderItemRequestDTO.getPrice());

        Long orderId = orderItemRequestDTO.getOrderId();
        if (orderId != null) {
            Optional<OrderEntity> optionalOrder = orderDao.findById(orderId);
            if (optionalOrder.isPresent()) {
                existingOrderItem.setOrder(optionalOrder.get());
            } else {
                throw new IllegalArgumentException("Invalid orderId");
            }
        } else {
            existingOrderItem.setOrder(null);
        }

        int productId = orderItemRequestDTO.getProductId();
        if (productId ==-1) {
            Optional<Product1> optionalProduct = productDao.findById(productId);
            if (optionalProduct.isPresent()) {
                existingOrderItem.setProduct(optionalProduct.get());
            } else {
                throw new IllegalArgumentException("Invalid productId");
            }
        } else {
            existingOrderItem.setProduct(null);
        }

        return orderItemDao.save(existingOrderItem);
    }

    public void deleteOrderItem(Long orderItemId) {
        orderItemDao.deleteById(orderItemId);
    }

    public List<OrderItemEntity> getAllOrderItems() {
        return orderItemDao.findAll();
    }

    public OrderItemEntity getOrderItemById(Long orderItemId) {
        return orderItemDao.findById(orderItemId)
                .orElseThrow(() -> new NoSuchElementException("OrderItem not found"));
    }
}
