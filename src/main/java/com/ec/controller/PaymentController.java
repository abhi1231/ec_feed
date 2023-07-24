package com.ec.controller;

import com.ec.entity.PaymentEntity;
import com.ec.service.Payment.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentServiceImpl;


    @GetMapping
    public ResponseEntity<List<PaymentEntity>> getAllPayments() {
        List<PaymentEntity> payments = paymentServiceImpl.getAllPayments();
        return ResponseEntity.ok().body(payments);
    }

//    @GetMapping
//    public List<PaymentEntity> getAllCarts() {
//        return paymentServiceImpl.getAllPayments();
//    }
    @GetMapping("/{paymentId}")
    public ResponseEntity<Optional<PaymentEntity>> getPaymentById(@PathVariable("paymentId") Long paymentId) {
        Optional<PaymentEntity> payment = paymentServiceImpl.getPaymentById(paymentId);
        if (payment != null) {
            return ResponseEntity.ok().body(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PaymentEntity> createPayment(@RequestBody PaymentEntity payment) {
        PaymentEntity createdPayment = paymentServiceImpl.createPayment(payment);
        return ResponseEntity.ok().body(createdPayment);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<PaymentEntity> updatePayment(@PathVariable("paymentId") Long paymentId, @RequestBody PaymentEntity payment) {
        PaymentEntity updatedPayment = paymentServiceImpl.updatePayment(paymentId, payment);
        if (updatedPayment != null) {
            return ResponseEntity.ok().body(updatedPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable("paymentId") Long paymentId) {
        paymentServiceImpl.deletePayment(paymentId);
        }

}
