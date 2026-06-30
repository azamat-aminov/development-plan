package com.dev.development.plan.hateoas.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.dev.development.plan.hateoas.controller.OrderController;
import com.dev.development.plan.hateoas.entity.Order;
import com.dev.development.plan.hateoas.entity.OrderStatus;
import com.dev.development.plan.hateoas.model.OrderResponse;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class OrderModelAssembler
    implements RepresentationModelAssembler<Order, OrderResponse> {

  @Override
  public OrderResponse toModel(Order order) {

    OrderResponse dto = new OrderResponse();

    dto.setId(order.getId());
    dto.setTotal(order.getTotal());
    dto.setStatus(order.getStatus().name());

    dto.add(linkTo(methodOn(OrderController.class)
        .getOrder(order.getId()))
        .withSelfRel());

    if (order.getStatus() == OrderStatus.CREATED) {

      dto.add(linkTo(methodOn(OrderController.class)
          .pay(order.getId()))
          .withRel("pay"));

      dto.add(linkTo(methodOn(OrderController.class)
          .cancel(order.getId()))
          .withRel("cancel"));
    }

    if (order.getStatus() == OrderStatus.PAID) {

      dto.add(linkTo(methodOn(OrderController.class)
          .refund(order.getId()))
          .withRel("refund"));
    }

    return dto;
  }
}