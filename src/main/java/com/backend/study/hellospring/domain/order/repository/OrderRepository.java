package com.backend.study.hellospring.domain.order.repository;

import com.backend.study.hellospring.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
