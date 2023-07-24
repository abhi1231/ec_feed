package com.ec.controller;

import com.ec.entity.OrderEntity;
import com.ec.entity.Prize;
import com.ec.service.Order.OrderServiceImpl;
import com.ec.service.prize.PrizeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/order")
public class OrderController {



    @Autowired
    private PrizeImpl prize;

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> data = orderServiceImpl.getAllOrders();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Optional<OrderEntity>> getOrderById(@PathVariable("orderId") int order_item_id) {
        Optional<OrderEntity> order = orderServiceImpl.getOrderById(order_item_id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order) {
        OrderEntity createdOrder = orderServiceImpl.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @PutMapping("/{order_item_id}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable("order_item_id") int order_item_id, @RequestBody OrderEntity order) {
        OrderEntity updatedOrder = orderServiceImpl.updateOrder(order_item_id, order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable("orderId") int order_item_id) {
        orderServiceImpl.deleteOrder(order_item_id);
    }


}
