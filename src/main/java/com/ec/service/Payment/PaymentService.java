package com.ec.service.Payment;

import com.ec.entity.PaymentEntity;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<PaymentEntity> getAllPayments();

    Optional<PaymentEntity> getPaymentById(Long paymentId);

    PaymentEntity createPayment(PaymentEntity payment);

    PaymentEntity updatePayment(Long paymentId, PaymentEntity payment);

    void deletePayment(Long paymentId);
}
