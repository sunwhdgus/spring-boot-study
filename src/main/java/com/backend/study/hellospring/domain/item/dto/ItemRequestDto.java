package com.backend.study.hellospring.domain.item.dto;

import com.backend.study.hellospring.domain.item.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemRequestDto {
    private String name;
    private int price;
    private int stockQuantity;
    private String detail;

    // DTO -> Entity 변환 편의 메서드
    public Item toEntity() {
        return new Item(name, price, stockQuantity, detail);
    }
}
