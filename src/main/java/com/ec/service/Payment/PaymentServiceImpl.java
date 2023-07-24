package com.ec.service.Payment;

import com.ec.dao.PaymentDao;
import com.ec.entity.PaymentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public List<PaymentEntity> getAllPayments() {
        return paymentDao.findAll();
    }

    @Override
    public Optional<PaymentEntity> getPaymentById(Long paymentId) {
       return paymentDao.findById(paymentId);
    }

    @Override
    public PaymentEntity createPayment(PaymentEntity payment) {

       return  paymentDao.save(payment);
    }

    @Override
    public PaymentEntity updatePayment(Long paymentId, PaymentEntity updatedPayment) {

        return  paymentDao.save(updatedPayment);
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentDao.deleteById(paymentId);
    }
}
