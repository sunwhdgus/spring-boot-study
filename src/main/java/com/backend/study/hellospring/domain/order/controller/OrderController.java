package com.backend.study.hellospring.domain.order.controller;

import com.backend.study.hellospring.domain.order.dto.OrderRequestDto;
import com.backend.study.hellospring.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public String createOrder(@RequestBody OrderRequestDto requestDto) {
        orderService.order(requestDto);
        return "주문 성공!";
    }
}
