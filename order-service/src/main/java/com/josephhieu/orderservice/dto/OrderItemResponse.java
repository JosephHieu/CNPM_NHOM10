package com.josephhieu.orderservice.dto;

import com.josephhieu.orderservice.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {

    private Long id;

    private Long productId;
    private Integer quantity;
    private BigDecimal price;
}
