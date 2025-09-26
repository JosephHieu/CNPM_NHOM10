package com.josephhieu.paymentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;   // Tham chiếu tới Order trong order-service
    private Long userId;    // Tham chiếu tới User trong user-service
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private String method;  // CREDITCARD, MOMO, PAYPAL...
    private LocalDateTime paymentDate;
}
