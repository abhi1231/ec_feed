package com.ec.service.Order;

import com.ec.dao.OrderDao;
import com.ec.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDao orderDao;


    @Override
    public List<OrderEntity> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public Optional<OrderEntity> getOrderById(int orderId) {
        return orderDao.findById(orderId);
    }

    @Override
    public OrderEntity createOrder(OrderEntity order) {

        return orderDao.save(order);
    }

//    @Override
//    public OrderEntity updateOrder(Long orderId, OrderEntity updatedOrder) {
//        for (OrderEntity order : orders) {
//            if (order.getId().equals(orderId)) {
//                order.setOrderNumber(updatedOrder.getOrderNumber());
//                order.setOrderDate(updatedOrder.getOrderDate());
//                // Set other attributes as needed
//                return order;
//            }
//        }
//        return null; // Return null if order  ID is not found
//    }
@Override
public OrderEntity updateOrder(int order_item_id, OrderEntity updatedOrder) {

        return orderDao.save(updatedOrder);
}

    @Override
    public void deleteOrder(int order_item_id) {

         orderDao.deleteById(order_item_id);
    }
}
