package com.backend.study.hellospring.domain.order.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderRequestDto {
    private String username;
    private Long itemId;
    private int count;
}
