package com.josephhieu.paymentservice.repository;

import com.josephhieu.paymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    List<Payment> findByUserId(Long userId);
    List<Payment> findByOrderId(Long orderId);
}
