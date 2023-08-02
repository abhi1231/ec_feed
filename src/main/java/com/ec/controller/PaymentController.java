package com.ec.controller;

import com.ec.dto.PaymentRequestDTO;
import com.ec.entity.PaymentEntity;
import com.ec.service.Payment.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentServiceImpl;



    @PostMapping
    public ResponseEntity<PaymentEntity> createPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
        try {
            PaymentEntity savedPayment = paymentServiceImpl.createPayment(paymentRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPayment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<PaymentEntity> updatePayment(
            @PathVariable Long paymentId,
            @RequestBody PaymentRequestDTO paymentRequestDTO
    ) {
        try {
            PaymentEntity updatedPayment = paymentServiceImpl.updatePayment(paymentId, paymentRequestDTO);
            return ResponseEntity.ok(updatedPayment);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
        try {
            paymentServiceImpl.deletePayment(paymentId);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PaymentEntity>> getAllPayments() {
        List<PaymentEntity> payments = paymentServiceImpl.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentEntity> getPaymentById(@PathVariable Long paymentId) {
        try {
            PaymentEntity payment = paymentServiceImpl.getPaymentById(paymentId);
            return ResponseEntity.ok(payment);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
