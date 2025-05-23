package com.example.hateoasdemo.model;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private List<Order> orders;

    public User(Long id, String name, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
