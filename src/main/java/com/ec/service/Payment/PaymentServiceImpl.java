package com.ec.service.Payment;

import com.ec.dao.OrderDao;
import com.ec.dao.PaymentDao;
import com.ec.dto.PaymentRequestDTO;
import com.ec.entity.OrderEntity;
import com.ec.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

   @Autowired
    private OrderDao orderDao;


    public PaymentEntity createPayment(PaymentRequestDTO paymentRequestDTO) {
        PaymentEntity payment = new PaymentEntity();
        payment.setPaymentDate(paymentRequestDTO.getPaymentDate());
        payment.setPaymentMethod(paymentRequestDTO.getPaymentMethod());
        payment.setAmount(paymentRequestDTO.getAmount());

        Long orderId = paymentRequestDTO.getOrderId();
        if (orderId != null) {
            Optional<OrderEntity> optionalOrder = orderDao.findById(orderId);
            if (optionalOrder.isPresent()) {
                payment.setOrder(optionalOrder.get());
            } else {
                throw new IllegalArgumentException("Invalid orderId");
            }
        }

        return paymentDao.save(payment);
    }

    public PaymentEntity updatePayment(Long paymentId, PaymentRequestDTO paymentRequestDTO) {
        PaymentEntity existingPayment = paymentDao.findById(paymentId)
                .orElseThrow(() -> new NoSuchElementException("Payment not found"));

        existingPayment.setPaymentDate(paymentRequestDTO.getPaymentDate());
        existingPayment.setPaymentMethod(paymentRequestDTO.getPaymentMethod());
        existingPayment.setAmount(paymentRequestDTO.getAmount());

        Long orderId = paymentRequestDTO.getOrderId();
        if (orderId != null) {
            Optional<OrderEntity> optionalOrder = orderDao.findById(orderId);
            if (optionalOrder.isPresent()) {
                existingPayment.setOrder(optionalOrder.get());
            } else {
                throw new IllegalArgumentException("Invalid orderId");
            }
        } else {
            existingPayment.setOrder(null);
        }

        return paymentDao.save(existingPayment);
    }

    public void deletePayment(Long paymentId) {
        paymentDao.deleteById(paymentId);
    }

    public List<PaymentEntity> getAllPayments() {
        return paymentDao.findAll();
    }

    public PaymentEntity getPaymentById(Long paymentId) {
        return paymentDao.findById(paymentId)
                .orElseThrow(() -> new NoSuchElementException("Payment not found"));
    }

}
