package com.example.hateoasdemo.controller;

import com.example.hateoasdemo.model.Order;
import com.example.hateoasdemo.model.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Map<Long, User> users = new HashMap<>();

    static {
        users.put(1L, new User(1L, "Shubham", List.of(
            new Order(101L, "Book"),
            new Order(102L, "Laptop"))));
        users.put(2L, new User(2L, "Ravi", List.of(
            new Order(201L, "Mobile"))));
    }

    @GetMapping("/{id}")
    public EntityModel<User> getUser(@PathVariable Long id) {
        User user = users.get(id);
        if (user == null) throw new RuntimeException("User not found");

        EntityModel<User> model = EntityModel.of(user);
        model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAllUsers()).withRel("all-users"));
        model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getOrders(id)).withRel("user-orders"));
        return model;
    }

    @GetMapping
    public CollectionModel<EntityModel<User>> getAllUsers() {
        List<EntityModel<User>> userModels = new ArrayList<>();
        for (User user : users.values()) {
            EntityModel<User> model = EntityModel.of(user);
            model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getUser(user.getId())).withSelfRel());
            userModels.add(model);
        }
        return CollectionModel.of(userModels);
    }

    @GetMapping("/{id}/orders")
    public CollectionModel<Order> getOrders(@PathVariable Long id) {
        User user = users.get(id);
        if (user == null) throw new RuntimeException("User not found");
        return CollectionModel.of(user.getOrders());
    }
}
