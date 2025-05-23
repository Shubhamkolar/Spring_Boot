package com.example.hateoasdemo.model;

public class Order {
    private Long orderId;
    private String description;

    public Order(Long orderId, String description) {
        this.orderId = orderId;
        this.description = description;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getDescription() {
        return description;
    }
}
