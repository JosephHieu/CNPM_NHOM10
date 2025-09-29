package com.josephhieu.orderservice.dto;

import com.josephhieu.orderservice.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private Long id;

    private Long userId;

    private LocalDateTime orderDate;

    private BigDecimal totalAmount;

    private String status;

    private UserDto user;

    private List<OrderItemResponse> orderItems;
}
