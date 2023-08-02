package com.ec.controller;

import com.ec.dto.OrderRequestDTO;
import com.ec.entity.OrderEntity;
import com.ec.service.Order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/order")
public class OrderController {




    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        try {
            OrderEntity savedOrder = orderServiceImpl.createOrder(orderRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/{orderId}")
    public ResponseEntity<OrderEntity> updateOrder(
            @PathVariable long orderId,
            @RequestBody OrderRequestDTO orderRequestDTO
    ) {
        try {
            OrderEntity updatedOrder = orderServiceImpl.updateOrder(orderId, orderRequestDTO);
            return ResponseEntity.ok(updatedOrder);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long orderId) {
        try {
            orderServiceImpl.deleteOrder(orderId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> orders = orderServiceImpl.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderEntity> getOrderById(@PathVariable long orderId) {
        try {
            OrderEntity order = orderServiceImpl.getOrderById(orderId);
            return ResponseEntity.ok(order);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
