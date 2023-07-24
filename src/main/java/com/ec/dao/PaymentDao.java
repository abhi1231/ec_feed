package com.ec.dao;

import com.ec.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<PaymentEntity,Long> {
}
