package com.josephhieu.orderservice.controller;

import com.josephhieu.orderservice.client.UserClient;
import com.josephhieu.orderservice.dto.OrderItemResponse;
import com.josephhieu.orderservice.dto.OrderResponse;
import com.josephhieu.orderservice.dto.UserDto;
import com.josephhieu.orderservice.model.Order;
import com.josephhieu.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final UserClient userClient;

    @GetMapping
    public List<Order> getOrders() {

        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);

        UserDto userDto = userClient.getUserById(order.getUserId());

        List<OrderItemResponse> orderItemResponses = order.getOrderItems()
                .stream()
                .map(item -> new OrderItemResponse(
                        item.getId(),
                        item.getProductId(),
                        item.getQuantity(),
                        item.getPrice()
                ))
                .toList();

        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getOrderDate(),
                order.getTotalAmount(),
                order.getStatus(),
                userDto,
                orderItemResponses
        );
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public boolean deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }

    private OrderResponse mapToResponse(Order order) {
        // gọi sang user-service để lấy thông tin user
        UserDto userDto = userClient.getUserById(order.getUserId());

        // map list OrderItem -> OrderItemResponse
        List<OrderItemResponse> orderItemResponses = order.getOrderItems()
                .stream()
                .map(item -> new OrderItemResponse(
                        item.getId(),
                        item.getProductId(),
                        item.getQuantity(),
                        item.getPrice()
                ))
                .toList();

        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getOrderDate(),
                order.getTotalAmount(),
                order.getStatus(),
                userDto,
                orderItemResponses
        );
    }

}