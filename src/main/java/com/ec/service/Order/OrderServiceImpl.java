package com.ec.service.Order;

import com.ec.dao.CustomerDao;
import com.ec.dao.OrderDao;
import com.ec.dto.OrderRequestDTO;
import com.ec.entity.Customer;
import com.ec.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerDao customerDao;

    public OrderEntity createOrder(OrderRequestDTO orderRequestDTO) {
        OrderEntity order = new OrderEntity();
        order.setOrderDate(orderRequestDTO.getOrderDate());
        order.setTotalAmount(orderRequestDTO.getTotalAmount());
        order.setStatus(orderRequestDTO.getStatus());

        Long customerId = orderRequestDTO.getCustomerId();
        if (customerId != null) {
            Optional<Customer> optionalCustomer = customerDao.findById(customerId);
            if (optionalCustomer.isPresent()) {
                order.setCustomer(optionalCustomer.get());
            } else {
                throw new IllegalArgumentException("Invalid customerId");
            }
        }

        return orderDao.save(order);
    }

    public OrderEntity updateOrder(long orderId, OrderRequestDTO orderRequestDTO) {
        OrderEntity existingOrder = orderDao.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));

        existingOrder.setOrderDate(orderRequestDTO.getOrderDate());
        existingOrder.setTotalAmount(orderRequestDTO.getTotalAmount());
        existingOrder.setStatus(orderRequestDTO.getStatus());

        Long customerId = orderRequestDTO.getCustomerId();
        if (customerId != null) {
            Optional<Customer> optionalCustomer = customerDao.findById(customerId);
            if (optionalCustomer.isPresent()) {
                existingOrder.setCustomer(optionalCustomer.get());
            } else {
                throw new IllegalArgumentException("Invalid customerId");
            }
        } else {
            existingOrder.setCustomer(null);
        }

        return orderDao.save(existingOrder);
    }

    public void deleteOrder(long orderId) {
        orderDao.deleteById(orderId);
    }

    public List<OrderEntity> getAllOrders() {
        return orderDao.findAll();
    }

    public OrderEntity getOrderById(long orderId) {
        return orderDao.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("Order not found"));
    }




}
