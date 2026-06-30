package com.dev.development.plan.hateoas.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.dev.development.plan.hateoas.assembler.OrderModelAssembler;
import com.dev.development.plan.hateoas.entity.Order;
import com.dev.development.plan.hateoas.model.CreateOrderRequest;
import com.dev.development.plan.hateoas.model.OrderResponse;
import com.dev.development.plan.hateoas.service.OrderService;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderService service;
  private final OrderModelAssembler assembler;

  public OrderController(OrderService service,
      OrderModelAssembler assembler) {

    this.service = service;
    this.assembler = assembler;
  }


  @PostMapping
  public ResponseEntity<OrderResponse> create(
      @RequestBody CreateOrderRequest request) {

    Order order = service.create(request);

    return ResponseEntity
        .created(linkTo(methodOn(OrderController.class)
            .getOrder(order.getId()))
            .toUri())
        .body(assembler.toModel(order));
  }

  @GetMapping("/{id}")
  public OrderResponse getOrder(@PathVariable Long id) {

    return Optional.ofNullable(id)
        .map(service::getOrder)
        .map(assembler::toModel)
        .orElseThrow();
  }

  @PostMapping("/{id}/pay")
  public OrderResponse pay(@PathVariable Long id) {

    return Optional.ofNullable(id)
        .map(service::pay)
        .map(assembler::toModel)
        .orElseThrow();
  }

  @PostMapping("/{id}/cancel")
  public OrderResponse cancel(@PathVariable Long id) {

    return Optional.ofNullable(id).map(service::cancel)
        .map(assembler::toModel)
        .orElseThrow();
  }

  @PostMapping("/{id}/refund")
  public OrderResponse refund(@PathVariable Long id) {

    return Optional.ofNullable(id)
        .map(service::getOrder)
        .map(assembler::toModel)
        .orElseThrow();
  }
}
