package com.dev.development.plan.hateoas.repository;

import com.dev.development.plan.hateoas.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
