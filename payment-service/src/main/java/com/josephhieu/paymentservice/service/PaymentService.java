package com.josephhieu.paymentservice.service;


import com.josephhieu.paymentservice.model.Payment;
import com.josephhieu.paymentservice.model.PaymentStatus;
import com.josephhieu.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment createPayment(Payment payment) {
        payment.setStatus(PaymentStatus.PENDING);
        payment.setPaymentDate(LocalDateTime.now());
        return paymentRepository.save(payment);
    }

    public Payment updatePaymentStatus(Long id, PaymentStatus status) {
        return paymentRepository.findById(id).map(p -> {
            p.setStatus(status);
            return paymentRepository.save(p);
        }).orElse(null);
    }
}
