package com.dev.development.plan.hateoas.service;

import com.dev.development.plan.hateoas.entity.Order;
import com.dev.development.plan.hateoas.entity.OrderStatus;
import com.dev.development.plan.hateoas.model.CreateOrderRequest;
import com.dev.development.plan.hateoas.repository.OrderRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final OrderRepository repository;

  public OrderService(OrderRepository repository) {
    this.repository = repository;
  }

  public Order create(CreateOrderRequest request) {

    return Optional.ofNullable(request)
        .map(req -> {
          Order order = new Order();
          order.setTotal(request.getTotal());
          order.setStatus(OrderStatus.CREATED);
          return order;
        })
        .map(repository::save)
        .orElseThrow(RuntimeException::new);
  }

  public Order getOrder(Long id) {

    return repository.findById(id)
        .orElseThrow();
  }

  public Order pay(Long id) {

    return Optional.ofNullable(id)
        .map(this::getOrder)
        .map(e -> {
          e.setStatus(OrderStatus.PAID);
          return e;
        }).map(repository::save)
        .orElseThrow();

  }

  public Order cancel(Long id) {

    return Optional.ofNullable(id)
        .map(this::getOrder)
        .map(e -> {
          e.setStatus(OrderStatus.CANCELLED);
          return e;
        }).map(repository::save).orElseThrow();
  }
}
