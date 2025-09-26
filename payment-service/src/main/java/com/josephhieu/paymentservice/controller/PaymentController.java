package com.josephhieu.paymentservice.controller;

import com.josephhieu.paymentservice.model.Payment;
import com.josephhieu.paymentservice.model.PaymentStatus;
import com.josephhieu.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.createPayment(payment);
    }

    @PutMapping("/{id}/status")
    public Payment updateStatus(@PathVariable Long id, @RequestParam PaymentStatus status) {
        return paymentService.updatePaymentStatus(id, status);
    }

}
