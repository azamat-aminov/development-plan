package com.dev.development.plan.hateoas.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class OrderResponse extends RepresentationModel<OrderResponse> {

  private Long id;
  private Double total;
  private String status;

}
