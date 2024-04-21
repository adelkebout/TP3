package org.example;

public class OrderController {
    private static OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void createOrder(Order order) {
        orderService.createOrder(order);
    }
}
