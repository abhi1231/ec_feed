package com.ec.controller;

import com.ec.dto.OrderItemRequestDTO;
import com.ec.entity.OrderItemEntity;
import com.ec.service.orderItem.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemServiceImpl orderItemServiceImpl;

    @PostMapping
    public ResponseEntity<OrderItemEntity> createOrderItem(@RequestBody OrderItemRequestDTO orderItemRequestDTO) {
        try {
            OrderItemEntity savedOrderItem = orderItemServiceImpl.createOrderItem(orderItemRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrderItem);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{orderItemId}")
    public ResponseEntity<OrderItemEntity> updateOrderItem(
            @PathVariable Long orderItemId,
            @RequestBody OrderItemRequestDTO orderItemRequestDTO
    ) {
        try {
            OrderItemEntity updatedOrderItem = orderItemServiceImpl.updateOrderItem(orderItemId, orderItemRequestDTO);
            return ResponseEntity.ok(updatedOrderItem);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{orderItemId}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long orderItemId) {
        try {
            orderItemServiceImpl.deleteOrderItem(orderItemId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderItemEntity>> getAllOrderItems() {
        List<OrderItemEntity> orderItems = orderItemServiceImpl.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/{orderItemId}")
    public ResponseEntity<OrderItemEntity> getOrderItemById(@PathVariable Long orderItemId) {
        try {
            OrderItemEntity orderItem = orderItemServiceImpl.getOrderItemById(orderItemId);
            return ResponseEntity.ok(orderItem);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
